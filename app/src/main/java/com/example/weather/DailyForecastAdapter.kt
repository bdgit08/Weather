package com.example.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.model.Cuaca
import kotlinx.android.synthetic.main.item_forecast_daily.view.*

class DailyForecastAdapter : RecyclerView.Adapter<DailyForecastAdapter.DailyForecastViewHolder>() {
    private var forecastMap = mutableMapOf<String,List<Cuaca>>()
    private var listKeys = mutableListOf<String>()

    fun addData(map: Map<String, List<Cuaca>>) {
        forecastMap.clear()
        listKeys.clear()
        forecastMap.putAll(map)
        listKeys.addAll(forecastMap.keys)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyForecastViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_forecast_daily, parent, false)
        return DailyForecastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listKeys.size
    }

    override fun onBindViewHolder(holder: DailyForecastViewHolder, position: Int) {
        val keys = listKeys.get(position)
        holder.bind(forecastMap.get(keys)!!,keys)
    }


    inner class DailyForecastViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(list:List<Cuaca>, day : String) {
            view.tvDay.text = day
            val adapter = ForecastFiveAdapter()
            view.rvDaily.adapter = adapter
            adapter.addData(list)
        }

    }

}