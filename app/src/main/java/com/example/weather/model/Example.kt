package com.example.weather.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Example : Serializable {

    @SerializedName("message")
    @Expose
    var message: Double? = null
    @SerializedName("cod")
    @Expose
    var cod: String? = null
    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null
    @SerializedName("list")
    @Expose
    var list: List<Cuaca>? = null
    @SerializedName("city")
    @Expose
    var city: City? = null

    companion object {
        private const val serialVersionUID = -1713723175642873935L
    }

}
