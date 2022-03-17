package ru.maksonic.roscosmos.screen.settings.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.maksonic.roscosmos.screen.settings.R.*
import ru.maksonic.roscosmos.screen.settings.SettingsViewModel
import ru.maksonic.roscosmos.shared.ui.R
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.clickAction

/**
 * @Author: maksonic on 17.03.2022
 */
@Composable
fun SettingItemSelectTheme(
    modifier: Modifier = Modifier,
    popupThemeMenu: MutableState<Boolean>,
    viewModel: SettingsViewModel,
    darkMode: MutableState<Boolean>
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(RCTheme.componentSize.btnModalSheetItem)
            .clickAction(onClick = { popupThemeMenu.value = true }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = modifier.padding(start = RCTheme.shape.padding16),
            painter = painterResource(id = R.drawable.ic_settings_item_theme),
            contentDescription = null,
            tint = RCTheme.color.secondaryText
        )
        Text(
            modifier = modifier
                .padding(
                    start = RCTheme.shape.padding16,
                    end = RCTheme.shape.padding16
                )
                .weight(1f),
            text = stringResource(id = string.item_select_theme),
            style = RCTheme.typography.title,
            color = RCTheme.color.secondaryText
        )
        Box(modifier.padding(end = RCTheme.shape.padding16)) {
            DropdownMenu(
                expanded = popupThemeMenu.value,
                onDismissRequest = {
                    popupThemeMenu.value = false
                },
                modifier = modifier
                    .wrapContentWidth(Alignment.End)
                    .background(RCTheme.color.surface)
            ) {
                DropdownMenuItem(
                    onClick = {
                        viewModel.setSystemTheme()
                        popupThemeMenu.value = false
                    },
                ) {
                    Row(modifier.fillMaxWidth()) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_theme_system_mode),
                            contentDescription = null,
                            tint = RCTheme.color.primary
                        )

                        Text(
                            text = stringResource(id = string.popup_sys_theme),
                            modifier = modifier.padding(start = RCTheme.shape.padding8),
                            style = RCTheme.typography.body,
                            color = RCTheme.color.secondaryText
                        )
                    }
                }
                DropdownMenuItem(
                    onClick = {
                        viewModel.setLightTheme()
                        popupThemeMenu.value = false
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_theme_light_mode),
                        contentDescription = null,
                        tint = RCTheme.color.primary
                    )

                    Text(
                        text = stringResource(id = string.popup_light_theme),
                        modifier = modifier.padding(start = RCTheme.shape.padding8),
                        style = RCTheme.typography.body,
                        color = RCTheme.color.secondaryText
                    )
                }
                DropdownMenuItem(
                    onClick = {
                        viewModel.setDarkTheme(darkMode)
                        popupThemeMenu.value = false
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_theme_dark_mode),
                        contentDescription = null,
                        tint = RCTheme.color.primary
                    )

                    Text(
                        text = stringResource(id = string.popup_dark_theme),
                        modifier = modifier.padding(start = RCTheme.shape.padding8),
                        style = RCTheme.typography.body,
                        color = RCTheme.color.secondaryText
                    )
                }

                DropdownMenuItem(
                    onClick = {
                        viewModel.setBrandTheme()
                        popupThemeMenu.value = false
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_theme_rc_mode),
                        contentDescription = null,
                        tint = RCTheme.color.primary
                    )

                    Text(
                        text = stringResource(id = string.popup_rc_theme),
                        modifier = modifier.padding(start = RCTheme.shape.padding8),
                        style = RCTheme.typography.body,
                        color = RCTheme.color.secondaryText
                    )
                }
            }
        }
    }
}