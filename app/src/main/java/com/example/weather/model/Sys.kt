package com.example.weather.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sys : Serializable {

    @SerializedName("pod")
    @Expose
    var pod: String? = null

    companion object {
        private const val serialVersionUID = 9204794485053588513L
    }

}
