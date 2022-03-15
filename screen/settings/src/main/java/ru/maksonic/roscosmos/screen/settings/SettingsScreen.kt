package ru.maksonic.roscosmos.screen.settings

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch
import ru.maksonic.roscosmos.core.settings.AppTheme
import ru.maksonic.roscosmos.core.settings.ThemeSetting
import ru.maksonic.roscosmos.shared.ui.R.drawable
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.clickAction
import ru.maksonic.roscosmos.shared.ui.theme.component.NormalAppTopBar

/**
 * @Author: maksonic on 10.03.2022
 */
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    toolbarBackPressed: () -> Unit,
    onThemeSelected: (AppTheme) -> Unit,
    themeSetting: ThemeSetting,
    darkMode: MutableState<Boolean>,
) {
    val scrollState = rememberScrollState()
    val popupThemeMenu = remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        modifier.systemBarsPadding(),
        backgroundColor = RCTheme.color.background,
        topBar = {
            NormalAppTopBar(
                title = stringResource(id = R.string.title_toolbar_settings),
                action = toolbarBackPressed
            )
        }
    ) {
        Column(
            modifier
                .fillMaxSize()
                .scrollable(scrollState, orientation = Orientation.Vertical)
        ) {
            Spacer(modifier.height(RCTheme.shape.padding16))
            SettingHeader(header = stringResource(id = R.string.header_theme))
            Spacer(modifier = modifier.height(RCTheme.shape.padding8))
            SettingItemSelectTheme(
                popupThemeMenu = popupThemeMenu,
                onThemeSelected = onThemeSelected,
                themeSetting = themeSetting,
                darkMode = darkMode
            )
            SettingItem(
                icon = painterResource(id = drawable.ic_settings_item_font_size),
                title = stringResource(id = R.string.item_change_font_size),
                action = {
                    scope.launch {
                        Toast.makeText(context, darkMode.value.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            )
            Spacer(modifier.height(RCTheme.shape.padding16))
            SettingHeader(header = stringResource(id = R.string.header_notification))
            Spacer(modifier = modifier.height(RCTheme.shape.padding8))
            SettingToggleItem(
                icon = painterResource(id = drawable.ic_settings_push_stream),
                title = stringResource(id = R.string.item_notification_live),
                action = {}
            )
            SettingToggleItem(
                icon = painterResource(id = drawable.ic_news_outlined),
                title = stringResource(id = R.string.item_notification_news),
                action = {}
            )
        }
    }
}


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

@Composable
fun SettingItemSelectTheme(
    modifier: Modifier = Modifier,
    popupThemeMenu: MutableState<Boolean>,
    onThemeSelected: (AppTheme) -> Unit,
    themeSetting: ThemeSetting,
    darkMode: MutableState<Boolean>,
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
            painter = painterResource(id = drawable.ic_settings_item_theme),
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
            text = stringResource(id = R.string.item_select_theme),
            style = RCTheme.typography.title,
            color = RCTheme.color.secondaryText
        )
        Box(modifier.padding(end = RCTheme.shape.padding16)) {
            DropdownMenu(
                expanded = popupThemeMenu.value,
                onDismissRequest = {
                    popupThemeMenu.value = false
                },
                modifier = Modifier
                    .wrapContentWidth(Alignment.End)
                    .background(RCTheme.color.surface)
            ) {
                DropdownMenuItem(
                    onClick = {
                        onThemeSelected(themeSetting.setupTheme(AppTheme.RC_SYSTEM.ordinal))
                        popupThemeMenu.value = false
                    },
                ) {
                    Row(modifier.fillMaxWidth()) {
                        Icon(
                            painter = painterResource(id = drawable.ic_theme_system_mode),
                            contentDescription = null,
                            tint = RCTheme.color.primary
                        )

                        Text(
                            text = stringResource(id = R.string.popup_sys_theme),
                            modifier = modifier.padding(start = RCTheme.shape.padding8),
                            style = RCTheme.typography.body,
                            color = RCTheme.color.secondaryText
                        )
                    }
                }
                DropdownMenuItem(
                    onClick = {
                        onThemeSelected(themeSetting.setupTheme(AppTheme.RC_LIGHT.ordinal))
                        popupThemeMenu.value = false
                    }
                ) {
                    Icon(
                        painter = painterResource(id = drawable.ic_theme_light_mode),
                        contentDescription = null,
                        tint = RCTheme.color.primary
                    )

                    Text(
                        text = stringResource(id = R.string.popup_light_theme),
                        modifier = modifier.padding(start = RCTheme.shape.padding8),
                        style = RCTheme.typography.body,
                        color = RCTheme.color.secondaryText
                    )
                }
                DropdownMenuItem(
                    onClick = {
                        darkMode.value = true
                        onThemeSelected(themeSetting.setupTheme(AppTheme.RC_DARK.ordinal))
                        popupThemeMenu.value = false
                    }
                ) {
                    Icon(
                        painter = painterResource(id = drawable.ic_theme_dark_mode),
                        contentDescription = null,
                        tint = RCTheme.color.primary
                    )

                    Text(
                        text = stringResource(id = R.string.popup_dark_theme),
                        modifier = modifier.padding(start = RCTheme.shape.padding8),
                        style = RCTheme.typography.body,
                        color = RCTheme.color.secondaryText
                    )
                }

                DropdownMenuItem(
                    onClick = {
                        onThemeSelected(themeSetting.setupTheme(AppTheme.RC_BRAND.ordinal))
                        popupThemeMenu.value = false
                    }
                ) {
                    Icon(
                        painter = painterResource(id = drawable.ic_theme_rc_mode),
                        contentDescription = null,
                        tint = RCTheme.color.primary
                    )

                    Text(
                        text = stringResource(id = R.string.popup_rc_theme),
                        modifier = modifier.padding(start = RCTheme.shape.padding8),
                        style = RCTheme.typography.body,
                        color = RCTheme.color.secondaryText
                    )
                }
            }
        }
    }
}

