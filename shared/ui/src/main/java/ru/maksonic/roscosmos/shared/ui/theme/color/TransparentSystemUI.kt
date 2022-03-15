package ru.maksonic.roscosmos.shared.ui.theme.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.maksonic.roscosmos.core.settings.AppTheme

/**
 * @Author: maksonic on 10.03.2022
 */
@Composable
fun InitSystemComponentsColor(
    isDarkMode: Boolean,
    themeType: State<AppTheme>,
    systemUiController: SystemUiController = rememberSystemUiController(),
    actualBackgroundColor: Color
) {
    val minLuminanceForDarkIcons = .5f

    SideEffect {
        systemUiController.setStatusBarColor(
            color = setSystemComponentColor(isDarkMode, themeType),
            darkIcons = actualBackgroundColor.luminance() > minLuminanceForDarkIcons
        )

        systemUiController.setNavigationBarColor(
            color = setSystemComponentColor(isDarkMode, themeType),
            darkIcons = actualBackgroundColor.luminance() > minLuminanceForDarkIcons,
            navigationBarContrastEnforced = false
        )
    }
}

private fun setSystemComponentColor(
    isDarkMode: Boolean,
    themeType: State<AppTheme>
): Color = when (themeType.value) {
    AppTheme.RC_BRAND -> baseBrandPalette.background
    AppTheme.RC_LIGHT -> baseLightPalette.background
    AppTheme.RC_DARK -> baseDarkPalette.background
    AppTheme.RC_SYSTEM -> {
        if (isDarkMode) baseDarkPalette.background else baseLightPalette.background
    }
}