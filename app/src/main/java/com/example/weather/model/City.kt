package com.example.weather.model

import java.io.Serializable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class City : Serializable {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("coord")
    @Expose
    var coord: Coord? = null
    @SerializedName("country")
    @Expose
    var country: String? = null

    companion object {
        private const val serialVersionUID = -7854799799667355593L
    }

}
