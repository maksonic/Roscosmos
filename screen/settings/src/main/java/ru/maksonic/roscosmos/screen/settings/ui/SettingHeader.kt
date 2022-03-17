package ru.maksonic.roscosmos.screen.settings.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme

/**
 * @Author: maksonic on 17.03.2022
 */
@Composable
fun SettingHeader(modifier: Modifier = Modifier, header: String) {
    Text(
        modifier = modifier.padding(
            start = RCTheme.shape.padding16,
            end = RCTheme.shape.padding16
        ),
        text = header,
        style = RCTheme.typography.header,
        color = RCTheme.color.primary,
    )
}