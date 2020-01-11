package com.example.weather

import java.text.SimpleDateFormat
import java.util.*

class FormatTimes {
    companion object {
        fun convertTimeEpochToDate(unixTime: Long,format:String): String {
            val sdf = SimpleDateFormat(format, Locale.getDefault())
            return sdf.format(Date(unixTime * 1000L))
        }

        fun convertTimeEpochToDateSystem(unixTime: Long,format:String): String {
            val sdf = SimpleDateFormat(format, Locale.getDefault())
            return sdf.format(Date(unixTime))
        }

        fun timeBackground() : String{
            val c = Calendar.getInstance()
            val timeOfDay = c.get(Calendar.HOUR_OF_DAY)
            return when (timeOfDay) {
                in 6..18 -> "#1976D2"
                in 18..23->"#01345F"
                else -> "#011830"
            }
        }
    }
}