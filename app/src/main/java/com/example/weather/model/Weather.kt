package com.example.weather.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Weather : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("main")
    @Expose
    var main: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null

    companion object {
        private const val serialVersionUID = -1029791787610268381L
    }

}
