package ru.maksonic.roscosmos.shared.ui.theme.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme

/**
 * @Author: maksonic on 10.03.2022
 */
@Composable
fun ScreenHeader(modifier: Modifier = Modifier, title: String) {
    Row(modifier.padding(start = RCTheme.shape.padding16, end = RCTheme.shape.padding16)) {
        Text(text = title, style = RCTheme.typography.display, color = RCTheme.color.primary)
    }
}