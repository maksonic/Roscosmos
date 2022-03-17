package ru.maksonic.roscosmos.screen.news

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
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