package com.example.weather

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.weather.model.Cuaca
import com.example.weather.model.Example
import com.example.weather.model.ServiceApi
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_weather_info.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class WeatherInfoActivity : AppCompatActivity() {
    private val adapter = DailyForecastAdapter()
    private var city = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_info)
        nested.setBackgroundColor(Color.parseColor(FormatTimes.timeBackground()))
        val name = intent.getStringExtra(NAME)
        val zipCode = intent.getStringExtra(ZIPCODE)
        city = intent.getStringExtra(CITY).capitalize()
        tvName.append(timeFromAndroid(name))
        tvZipCode.append("${city}, $zipCode ")
        recycleView.adapter = adapter
        getData(zipCode)
    }


    private fun getData(zipCode: String) {
        ServiceApi.create()
            .callForecast(zipCode, "c7efcb17d216f4559c8236ce6281eefe", "$city,id", "metric")
            .enqueue(object : Callback<Example> {
                override fun onFailure(call: Call<Example>, t: Throwable) {
                    if (t is IOException || t is HttpException){
                        tvError.text = "Tidak ada koneksi internet"
                        tvError.visibility = View.VISIBLE
                        ivError.visibility = View.VISIBLE
                    }
                }

                override fun onResponse(call: Call<Example>, response: Response<Example>) {
                    if (response.code() == 404){
                        val str = response.errorBody()?.string()
                        val jsonError = JSONObject(str)
                        tvError.text = jsonError.getString("message")
                        tvError.visibility = View.VISIBLE
                        ivError.visibility = View.VISIBLE
                    }else{
                        val forecasts = response.body()?.list
                        val groupForecast = forecasts?.groupBy { cuaca ->
                            cuaca.date
                        }
                        getTodayWeather(forecasts!!.get(0))
                        adapter.addData(groupForecast!!)
                        containerInfo?.visibility = View.VISIBLE
                    }
                }
            })
    }

    private fun getTodayWeather(cuaca: Cuaca) {
        val url =
            "https://openweathermap.org/themes/openweathermap/assets/vendor/owm/img/widgets/${cuaca.weather?.get(
                0
            )!!.icon}.png"
        tvValueTempToday.text = "${cuaca.main!!.temp!!.toInt()} \u2103"
        tvStatusTempToday.text = cuaca!!.weather!!.get(0).main
        Glide.with(ivWeatherToday).load(url).into(ivWeatherToday)
    }

    private fun timeFromAndroid(name: String): String {
        val c = Calendar.getInstance()
        val timeOfDay = c.get(Calendar.HOUR_OF_DAY)
        return when (timeOfDay) {
            in 0..11 -> "Selamat Pagi, $name"
            in 12..15 -> "Selamat Siang, $name"
            in 16..18 -> "Selamat Sore, $name"
            in 18..23 -> "Selamat Malam, $name"
            else -> {
                "Hallo"
            }
        }
    }

    companion object {
        val NAME = "name"
        val CITY = "city"
        val ZIPCODE = "zipcode"
    }

}
