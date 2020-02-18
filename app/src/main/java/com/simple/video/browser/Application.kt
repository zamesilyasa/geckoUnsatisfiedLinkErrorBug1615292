package com.simple.video.browser

import android.content.Context
import mozilla.components.browser.engine.gecko.GeckoEngine
import mozilla.components.browser.session.SessionManager
import mozilla.components.browser.state.store.BrowserStore
import mozilla.components.concept.engine.DefaultSettings
import mozilla.components.concept.engine.Engine
import org.mozilla.geckoview.GeckoRuntime

class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        lateinit var app: Application
        val components: Components by lazy { Components(app) }
    }
}

class Components(private val context: Context) {

    val runtime: GeckoRuntime by lazy {
        GeckoRuntime.create(context)
    }

    val store by lazy {
        BrowserStore()
    }

    val engineSettings by lazy {
        DefaultSettings().apply {
            remoteDebuggingEnabled = true
            supportMultipleWindows = true
        }
    }

    val engine: Engine by lazy {
        GeckoEngine(
            Application.app,
            engineSettings,
            runtime
        )
    }

    val sessionManager by lazy {
        SessionManager(engine, store)
    }
}