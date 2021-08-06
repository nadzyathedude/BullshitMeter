package com.ronasit.bullshitmeter.ui.splash

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ronasit.bullshitmeter.R
import com.ronasit.bullshitmeter.ui.main.MainActivity
import java.util.*
import kotlin.concurrent.schedule


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val anim = AnimationUtils.loadAnimation(this, R.anim.splashscreen)
        val image = findViewById<ImageView>(R.id.image_view_loading)
        image.startAnimation(anim)
        Timer("timerToStartMainActivity", false).schedule(1000) {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}