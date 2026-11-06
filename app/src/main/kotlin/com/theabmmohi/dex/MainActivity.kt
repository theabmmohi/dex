package com.theabmmohi.dex

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dexIntent = Intent().apply {
            component = ComponentName(
                "com.android.settings",
                "com.android.settings.Settings\$DexModeActivity"
            )
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        try {
            startActivity(dexIntent)
        } catch (e: ActivityNotFoundException) {
            openFallback()
        } catch (e: SecurityException) {
            openFallback()
        }
        finish()
    }

    private fun openFallback() {
        Toast.makeText(this, "DeX settings not available on this device", Toast.LENGTH_LONG).show()
        startActivity(Intent(Settings.ACTION_SETTINGS).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}
