package ru.maksonic.roscosmos.shared.ui.theme.shape

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @Author: maksonic on 09.03.2022
 */
val LocalRCComponentSize = staticCompositionLocalOf<RCComponentSize> {
    error("No component size provided")
}

data class RCComponentSize(
    val btnNav: Dp,
    val btnPrimaryHeight: Dp,
    val btnModalSheetItem: Dp
)

val componentSize = RCComponentSize(
    btnNav = 24.dp,
    btnPrimaryHeight = 54.dp,
    btnModalSheetItem = 48.dp
)