package com.example.weather.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wind : Serializable {

    @SerializedName("speed")
    @Expose
    var speed: Double? = null
    @SerializedName("deg")
    @Expose
    var deg: Double? = null

    companion object {
        private const val serialVersionUID = -4322146546034470714L
    }

}
