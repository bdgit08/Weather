package com.example.weather.model

import com.example.weather.FormatTimes
import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Cuaca : Serializable {

    @SerializedName("dt")
    @Expose
    var dt: Long? = null
    @SerializedName("main")
    @Expose
    var main: Main? = null
    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null
    @SerializedName("wind")
    @Expose
    var wind: Wind? = null
    @SerializedName("rain")
    @Expose
    var rain: Rain? = null
    @SerializedName("sys")
    @Expose
    var sys: Sys? = null
    @SerializedName("dt_txt")
    @Expose
    var dtTxt: String? = null
    var date: String = ""
        get() {
            val time = FormatTimes.convertTimeEpochToDateSystem(Date().time, "dd MMMM yyyy")
            val time2 = FormatTimes.convertTimeEpochToDate(dt!!, "dd MMMM yyyy")
            return if (time == time2) {
                "Hari ini"
            }else time2
        }

    companion object {
        private const val serialVersionUID = -359121440867785429L
    }

}
