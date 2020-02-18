package com.simple.video.browser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simple.video.browser.Application.Companion.components
import kotlinx.android.synthetic.main.component_activity.*
import mozilla.components.browser.session.Session

class ComponentsBrowserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.component_activity)

        initGeckoView()
    }

    private fun initGeckoView() {
        val url = "https://www.youtube.com/watch?v=WxnN05vOuSM&feature=youtu.be&t=42"

        val session = Session(url)

        val sessionManager = components.sessionManager
        sessionManager.removeSessions()
        sessionManager.add(session)
        sessionManager.select(session)

        val engineSession = sessionManager.getOrCreateEngineSession()
        engineSession.loadUrl(url)
        geckoView.render(engineSession)
    }
}