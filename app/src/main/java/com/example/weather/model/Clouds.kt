package com.example.weather.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Clouds : Serializable {

    @SerializedName("all")
    @Expose
    var all: Int? = null

    companion object {
        private const val serialVersionUID = 8852868845898850336L
    }

}
