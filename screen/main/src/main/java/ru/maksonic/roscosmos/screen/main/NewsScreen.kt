package ru.maksonic.roscosmos.screen.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.component.ScreenHeader

/**
 * @Author: maksonic on 09.03.2022
 */
@Composable
fun NewsScreen() {
    Scaffold(
        backgroundColor = RCTheme.color.background
    ) {
        ScreenHeader(title = "Новости")
    }
}