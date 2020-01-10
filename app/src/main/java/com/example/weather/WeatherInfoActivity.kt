package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather.model.Cuaca
import com.example.weather.model.Example
import com.example.weather.model.ServiceApi
import kotlinx.android.synthetic.main.activity_weather_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class WeatherInfoActivity : AppCompatActivity() {
    private val adapter = DailyForecastAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_info)
        val name = intent.getStringExtra(NAME)
        val zipCode = intent.getStringExtra(ZIPCODE)
        tvName.append(timeFromAndroid(name))
        tvZipCode.append("KODE POS : $zipCode")
        recycleView.adapter = adapter
        tvValueTempToday.text = "32 \u00B0"
        tvStatusTempToday.text = "Mostly Sunny"
        getData(zipCode)
    }

    private fun getData(zipCode: String) {
        ServiceApi.create()
            .callForecast(zipCode, "c7efcb17d216f4559c8236ce6281eefe", "Bandung,id", "metric")
            .enqueue(object : Callback<Example> {
                override fun onFailure(call: Call<Example>, t: Throwable) {
                    println("onFailure = " + t.message)
                }

                override fun onResponse(call: Call<Example>, response: Response<Example>) {
                    println("onResponse " + response)
                    println("onResponse size " + response.body()?.list?.size)
                    val forecasts = response.body()?.list
                    val groupForecast = forecasts?.groupBy { cuaca ->
                        cuaca.date
                    }
                    getTodayWeather(groupForecast?.get(FormatTime.convertDateToString(Date()))!!)
                    adapter.addData(groupForecast)
                    for (day in groupForecast!!.keys){
                        println("key = $day")
                        println("isi ${groupForecast.get(day)!!.size}")
                    }
                }

            })
    }

    private fun getTodayWeather(listToday : List<Cuaca>){
        val list = listOf(listToday)
        println("getTodayWeather isi ${listToday.size}")
        for (cuaca in listToday){
            println("date today =  ${cuaca.dtTxt}")
        }

        val simpleArray = arrayOf(1, 2, 10, 4, 5, 20)
        val average = simpleArray.average()
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
        val ZIPCODE = "zipcode"
    }


}
