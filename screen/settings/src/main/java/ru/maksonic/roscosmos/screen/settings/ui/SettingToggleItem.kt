package ru.maksonic.roscosmos.screen.settings.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.clickAction

/**
 * @Author: maksonic on 17.03.2022
 */
@Composable
fun SettingToggleItem(
    modifier: Modifier = Modifier,
    icon: Painter,
    title: String,
    action: () -> Unit
) {
    val checkedState = remember { mutableStateOf(true) }
    Row(
        modifier
            .fillMaxWidth()
            .height(RCTheme.componentSize.btnModalSheetItem)
            .clickAction {
                action.invoke()
                checkedState.value = checkedState.value != true
            },
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
        Spacer(modifier.weight(1f))
        Switch(
            modifier = modifier
                .padding(end = RCTheme.shape.padding16),
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = RCTheme.color.primary,
                checkedTrackColor = RCTheme.color.primary,
                uncheckedThumbColor = RCTheme.color.onPrimary,
                uncheckedTrackColor = RCTheme.color.secondaryVariant
            )
        )
    }
}