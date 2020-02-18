package com.simple.video.browser

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    fun openPureGeckoView(view: View) {
        startActivity(Intent(this, SimpleBrowserActivity::class.java))
    }
    fun openBrowserWithComponents(view: View) {
        startActivity(Intent(this, ComponentsBrowserActivity::class.java))
    }
}