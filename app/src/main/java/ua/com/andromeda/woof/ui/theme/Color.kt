package ua.com.andromeda.woof.ui.theme
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val md_theme_light_primary = Color(0xFF9F3E41)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFFFDAD8)
val md_theme_light_onPrimaryContainer = Color(0xFF410007)
val md_theme_light_secondary = Color(0xFF775655)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFDAD8)
val md_theme_light_onSecondaryContainer = Color(0xFF2C1515)
val md_theme_light_tertiary = Color(0xFF745A2F)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFDEAC)
val md_theme_light_onTertiaryContainer = Color(0xFF281900)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFBFF)
val md_theme_light_onBackground = Color(0xFF201A1A)
val md_theme_light_surface = Color(0xFFFFFBFF)
val md_theme_light_onSurface = Color(0xFF201A1A)
val md_theme_light_surfaceVariant = Color(0xFFF4DDDC)
val md_theme_light_onSurfaceVariant = Color(0xFF524342)
val md_theme_light_outline = Color(0xFF857372)
val md_theme_light_inverseOnSurface = Color(0xFFFBEEED)
val md_theme_light_inverseSurface = Color(0xFF362F2E)
val md_theme_light_inversePrimary = Color(0xFFFFB3B1)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF9F3E41)
val md_theme_light_outlineVariant = Color(0xFFD7C1C0)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFFFB3B1)
val md_theme_dark_onPrimary = Color(0xFF621017)
val md_theme_dark_primaryContainer = Color(0xFF80272B)
val md_theme_dark_onPrimaryContainer = Color(0xFFFFDAD8)
val md_theme_dark_secondary = Color(0xFFE6BDBB)
val md_theme_dark_onSecondary = Color(0xFF442929)
val md_theme_dark_secondaryContainer = Color(0xFF5D3F3E)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFDAD8)
val md_theme_dark_tertiary = Color(0xFFE4C18D)
val md_theme_dark_onTertiary = Color(0xFF412D05)
val md_theme_dark_tertiaryContainer = Color(0xFF5A4319)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFDEAC)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF201A1A)
val md_theme_dark_onBackground = Color(0xFFEDE0DF)
val md_theme_dark_surface = Color(0xFF201A1A)
val md_theme_dark_onSurface = Color(0xFFEDE0DF)
val md_theme_dark_surfaceVariant = Color(0xFF524342)
val md_theme_dark_onSurfaceVariant = Color(0xFFD7C1C0)
val md_theme_dark_outline = Color(0xFFA08C8B)
val md_theme_dark_inverseOnSurface = Color(0xFF201A1A)
val md_theme_dark_inverseSurface = Color(0xFFEDE0DF)
val md_theme_dark_inversePrimary = Color(0xFF9F3E41)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFFFB3B1)
val md_theme_dark_outlineVariant = Color(0xFF524342)
val md_theme_dark_scrim = Color(0xFF000000)


val seed = Color(0xFFFF8888)

@Composable
fun WoofTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColors
        else -> LightColors
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}