package net.inferno.courtcounter.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import net.inferno.courtcounter.layout.MainActivity
import net.inferno.courtcounter.theme.AppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                MainActivity()
            }
        }
    }
}