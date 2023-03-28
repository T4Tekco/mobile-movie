package com.android.t4tek.app.main.movie

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

class Background_splash : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this,MovieMain::class.java)
            startActivity(intent)
            finish()
        },1000)
    }
}