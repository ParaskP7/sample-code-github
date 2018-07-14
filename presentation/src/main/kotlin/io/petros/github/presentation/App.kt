package io.petros.github.presentation

import android.app.Application
import android.os.Build
import android.os.StrictMode
import com.squareup.leakcanary.LeakCanary
import io.petros.github.BuildConfig

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (!initLeakCanary()) return
        initStrictMode()
    }

    private fun initLeakCanary(): Boolean {
        return if (LeakCanary.isInAnalyzerProcess(this)) {
            false
        } else {
            LeakCanary.install(this)
            true
        }
    }

    private fun initStrictMode() {
        if (BuildConfig.DEBUG) {
            setThreadPolicyToStrictMode()
            setVmPolicyToStrictMode()
        }
    }

    private fun setThreadPolicyToStrictMode() {
        val strictModeBuilder = StrictMode.ThreadPolicy.Builder()
            .detectDiskReads()
            .detectDiskWrites()
            .detectNetwork()
            .detectCustomSlowCalls()
            .penaltyLog()
            .penaltyFlashScreen()
            .penaltyDialog()
        addAndroidMThreadPolicyToStrictMode(strictModeBuilder)
        addAndroidOThreadPolicyToStrictMode(strictModeBuilder)
        StrictMode.setThreadPolicy(strictModeBuilder.build())
    }

    private fun addAndroidMThreadPolicyToStrictMode(strictModeBuilder: StrictMode.ThreadPolicy.Builder) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            strictModeBuilder.detectResourceMismatches()
        }
    }

    private fun addAndroidOThreadPolicyToStrictMode(strictModeBuilder: StrictMode.ThreadPolicy.Builder) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            strictModeBuilder.detectUnbufferedIo()
        }
    }

    private fun setVmPolicyToStrictMode() {
        val strictModeBuilder = StrictMode.VmPolicy.Builder()
            .detectActivityLeaks()
            .detectFileUriExposure()
            .detectLeakedClosableObjects()
            .detectLeakedSqlLiteObjects()
            .detectLeakedRegistrationObjects()
            .penaltyLog()
        addAndroidOVmPolicyToStrictMode(strictModeBuilder)
        StrictMode.setVmPolicy(strictModeBuilder.build())
    }

    private fun addAndroidOVmPolicyToStrictMode(strictModeBuilder: StrictMode.VmPolicy.Builder) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            strictModeBuilder.detectCleartextNetwork()
                .detectContentUriWithoutPermission()
        }
    }

}
