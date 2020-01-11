package com.example.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weather.model.Cuaca
import kotlinx.android.synthetic.main.item_forecast_five.view.*

class ForecastFiveAdapter : RecyclerView.Adapter<ForecastFiveAdapter.ForecastFiveViewHolder>() {
    var listForecast = mutableListOf<Cuaca>()


    fun addData(list: List<Cuaca>){
        listForecast.clear()
        listForecast.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastFiveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast_five,parent,false)
        return ForecastFiveViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listForecast.size
    }

    override fun onBindViewHolder(holder: ForecastFiveViewHolder, position: Int) {
        holder.bind(listForecast.get(position))
    }


    inner class ForecastFiveViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        fun bind(cuaca: Cuaca){
            val weather  = cuaca.weather!!.get(0)
            val url = "https://openweathermap.org/themes/openweathermap/assets/vendor/owm/img/widgets/${weather.icon}.png"
            Glide.with(view.ivWeather).load(url).into(view.ivWeather)
            view.tvHari.text = FormatTimes.convertTimeEpochToDate(cuaca.dt!!,"HH:mm")
            view.tvStatusWheater.text = weather.main
            view.tvTemp.text = "${cuaca.main!!.temp!!.toInt()} \u2103"
        }
    }
}