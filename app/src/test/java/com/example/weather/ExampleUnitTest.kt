package com.example.weather

import org.junit.Test

import org.junit.Assert.*
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
        val date = FormatTime.convertStringToDate("2020-01-14 21:00:00")
        println(FormatTime.convertDateToString(Date()))

        val dou = 15.67
        println(dou.toFloat())
    }
}
