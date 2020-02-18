package com.simple.video.browser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.browser_activity.*
import org.mozilla.geckoview.GeckoSession

class SimpleBrowserActivity : AppCompatActivity() {
    private val geckoSession = GeckoSession()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.browser_activity)

        initGeckoView()
    }

    private fun initGeckoView() {
        geckoSession.open(Application.components.runtime)
        geckoView.setSession(geckoSession)
        geckoSession.loadUri("https://www.youtube.com/watch?v=eiFHJr7bKp4")
    }
}