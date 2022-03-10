package net.inferno.courtcounter.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import net.inferno.courtcounter.R

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isAndroid12: Boolean = Build.VERSION.SDK_INT >= 31,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = colors(isDarkTheme, isAndroid12),
    ) {
        content()
    }
}

@Composable
fun colors(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isAndroid12: Boolean = Build.VERSION.SDK_INT >= 31,
): ColorScheme {
    val context = LocalContext.current

    return if (isAndroid12) {
        if (isDarkTheme) {
            dynamicDarkColorScheme(context)
        } else {
            dynamicLightColorScheme(context)
        }
    } else {
        if (isDarkTheme) {
            darkColorScheme(
                primary = colorResource(R.color.colorPrimary),
                tertiary = colorResource(R.color.colorPrimaryDark),
                secondary = colorResource(R.color.colorPrimary),
                onPrimary = Color.White,
            )
        } else {
            lightColorScheme(
                primary = colorResource(R.color.colorPrimary),
                tertiary = colorResource(R.color.colorPrimaryDark),
                secondary = colorResource(R.color.colorPrimary),
                onPrimary = Color.White,
            )
        }
    }
}