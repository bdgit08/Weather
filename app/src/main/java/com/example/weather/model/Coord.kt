package com.example.weather.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord : Serializable {

    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    @SerializedName("lon")
    @Expose
    var lon: Double? = null

    companion object {
        private const val serialVersionUID = -1566721089347914581L
    }

}
