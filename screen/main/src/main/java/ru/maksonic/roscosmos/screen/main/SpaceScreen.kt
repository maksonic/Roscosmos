package ru.maksonic.roscosmos.screen.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.component.ScreenHeader

/**
 * @Author: maksonic on 09.03.2022
 */
@Composable
fun SpaceScreen() {
    Scaffold(
        backgroundColor = RCTheme.color.background
    ) {
        ScreenHeader(title = "Космос")

    }
}