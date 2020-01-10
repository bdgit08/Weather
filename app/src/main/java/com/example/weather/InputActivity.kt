package com.example.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        btnLihatCuaca.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (enabledInput()){
            val intent = Intent(this,WeatherInfoActivity::class.java)
            intent.putExtra(WeatherInfoActivity.NAME,editTextName.text.toString())
            intent.putExtra(WeatherInfoActivity.ZIPCODE,editTextKodePos.text.toString())
            startActivity(intent)
        }
    }

    private fun enabledInput() : Boolean{
        if (editTextName.length()>0 && editTextKodePos.length() > 4){
            return true
        }else {
            if (editTextName.length() == 0){
                editTextName.error = "Nama tidak boleh kosong"
            }else if (editTextKodePos.length() < 4){
                editTextKodePos.error = "Minimal inputan kodepos 5 digit"
            }
            return false
        }
    }
}
