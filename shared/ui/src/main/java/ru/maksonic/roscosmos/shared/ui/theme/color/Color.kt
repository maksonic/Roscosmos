package ru.maksonic.roscosmos.shared.ui.theme.color

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * @Author: maksonic on 09.03.2022
 */
val LocalRCColors = staticCompositionLocalOf<RCColor> {
    error("No colors provided")
}

data class RCColor(
    val primary: Color,
    val primaryVariant: Color,
    val onPrimary: Color,
    val secondary: Color,
    val secondaryVariant: Color,
    val tertiary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val divider: Color,
    val error: Color,
    val onError: Color,
    val transparent: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val tertiaryText: Color,
)

val Black = Color(0xFF000000)
val BlueLight = Color(0xFF8798BA)
val CarmineRed = Color(0xFFB00020)
val Chambray = Color(0xFF3F5B92)
val GainsboroGray = Color(0xFFDCDCDC)
val Nero = Color(0xFF212121)
val RCGray = Color(0xFF4D4D4D)
val RCRed = Color(0xFFED1941)
val RCBlue = Color(0xFF204080)
val Solitude = Color(0xFFF7F7F7)
val ShuttleGray = Color(0xFF7F8389)
val Transparent = Color(0x00FFFFFF)
val White = Color(0xFFFFFFFF)