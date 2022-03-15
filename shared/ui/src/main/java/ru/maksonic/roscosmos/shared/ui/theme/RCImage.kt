package ru.maksonic.roscosmos.shared.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * @Author: maksonic on 13.03.2022
 */
val LocalRCImage = staticCompositionLocalOf<RCImage> {
    error("No images provided")
}

data class RCImage(val roscosmosToolbarLogo: Int)