package ru.maksonic.roscosmos.shared.ui.theme.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * @Author: maksonic on 09.03.2022
 */
val LocalRCTypography = staticCompositionLocalOf<RCTypography> {
    error("No font provided")
}

data class RCTypography(
    val body: TextStyle,
    val title: TextStyle,
    val header: TextStyle,
    val toolbarTitle: TextStyle,
    val display: TextStyle
)

val typography = RCTypography(
    body = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    title = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    header = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    toolbarTitle = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
    ),
    display = TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold
    ),
)
