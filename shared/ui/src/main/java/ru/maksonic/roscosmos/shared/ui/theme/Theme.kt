package ru.maksonic.roscosmos.shared.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import ru.maksonic.roscosmos.shared.ui.R
import ru.maksonic.roscosmos.shared.ui.theme.color.*
import ru.maksonic.roscosmos.shared.ui.theme.shape.*
import ru.maksonic.roscosmos.shared.ui.theme.typography.LocalRCTypography
import ru.maksonic.roscosmos.shared.ui.theme.typography.RCTypography
import ru.maksonic.roscosmos.shared.ui.theme.typography.typography

/**
 * @Author: maksonic on 09.03.2022
 */
@Composable
fun RoscosmosTheme(
    lightPalette: RCColor,
    darkPalette: RCColor,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkPalette else lightPalette

    val images = RCImage(
        roscosmosToolbarLogo =
        if (darkTheme) {
            R.drawable.logo_rc_dark_theme
        } else {
            if (lightPalette == baseBrandPalette) {
                R.drawable.logo_rc_dark_theme
            } else {
                R.drawable.logo_rc_light_theme
            }
        }
    )

    CompositionLocalProvider(
        LocalRCColors provides colors,
        LocalRCTypography provides typography,
        LocalRCShape provides shapes,
        LocalRCImage provides images,
        LocalRCComponentSize provides componentSize,
        content = content
    )
}

object RCTheme {
    val color: RCColor @Composable get() = LocalRCColors.current
    val typography: RCTypography @Composable get() = LocalRCTypography.current
    val shape: RCShape @Composable get() = LocalRCShape.current
    val image: RCImage @Composable get() = LocalRCImage.current
    val componentSize: RCComponentSize @Composable get() = LocalRCComponentSize.current
}

@Composable
fun MainTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    RoscosmosTheme(
        lightPalette = baseLightPalette,
        darkPalette = baseDarkPalette,
        darkTheme,
        content
    )
}

@Composable
fun BrandTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    RoscosmosTheme(
        lightPalette = baseBrandPalette,
        darkPalette = baseDarkPalette,
        darkTheme,
        content
    )
}