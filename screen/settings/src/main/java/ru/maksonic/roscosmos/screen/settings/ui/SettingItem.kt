package ru.maksonic.roscosmos.screen.settings.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.clickAction

/**
 * @Author: maksonic on 17.03.2022
 */
@Composable
fun SettingItem(
    modifier: Modifier = Modifier,
    icon: Painter,
    title: String,
    action: () -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(RCTheme.componentSize.btnModalSheetItem)
            .clickAction(onClick = action),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = modifier.padding(start = RCTheme.shape.padding16),
            painter = icon,
            contentDescription = null,
            tint = RCTheme.color.secondaryText
        )
        Text(
            modifier = modifier.padding(
                start = RCTheme.shape.padding16,
                end = RCTheme.shape.padding16
            ),
            text = title,
            style = RCTheme.typography.title,
            color = RCTheme.color.secondaryText
        )
    }
}