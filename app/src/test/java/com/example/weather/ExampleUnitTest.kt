package com.example.weather

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testTime(){
        val c = Calendar.getInstance()
        val mDay = c.get(Calendar.DAY_OF_MONTH)
        println("day = $mDay")

        val dou = 15.67
        println(dou.toFloat())
    }

    @Test
    fun testTodayTime(){
        val c = Calendar.getInstance()
        val threeHourmilis = 10800000L
        val list = listOf<Long>(1578657600000)

        val unixtime = "1578657600"
        val date = Date()
        Instant.ofEpochMilli(1578657600*1000)
        val s = DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(1578657600).atZone(ZoneId.systemDefault()))
        val format = SimpleDateFormat("HH:mm",Locale.getDefault())
//        format.timeZone = TimeZone.getTimeZone("GMT+07:00")
        val str = format.format(Date(unixtime.toLong() * 1000L))
        val time = format.format(date)
        println(Date().time)
        println(str)

    }

    @Test
    fun testToday(){
        val formater  =  DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val unixtime = 1578657600L
        val formate= Instant.ofEpochSecond(unixtime).atZone(ZoneId.of("GMT+07:00")).format(formater)
        println(formate)
    }



}
