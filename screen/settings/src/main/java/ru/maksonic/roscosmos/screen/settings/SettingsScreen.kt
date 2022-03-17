package ru.maksonic.roscosmos.screen.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.maksonic.roscosmos.screen.settings.ui.*
import ru.maksonic.roscosmos.shared.ui.R.drawable
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.component.NormalAppTopBar

/**
 * @Author: maksonic on 10.03.2022
 */
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    toolbarBackPressed: () -> Unit
) {
    UiSettingsScreen(viewModel = viewModel, toolbarBackPressed = toolbarBackPressed)
}

@Composable
fun UiSettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel,
    toolbarBackPressed: () -> Unit
) {
    val scrollState = rememberScrollState()
    val popupThemeMenu = remember { mutableStateOf(false) }
    val darkMode = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var visible by remember { mutableStateOf(false) }

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
                .verticalScroll(state = scrollState)
        ) {
            Spacer(modifier.height(RCTheme.shape.padding16))
            SettingHeader(header = stringResource(id = R.string.header_theme))
            Spacer(modifier = modifier.height(RCTheme.shape.padding8))
            SettingItemSelectTheme(
                popupThemeMenu = popupThemeMenu,
                viewModel = viewModel,
                darkMode = darkMode
            )
            SettingItem(
                icon = painterResource(id = drawable.ic_settings_item_font_size),
                title = stringResource(id = R.string.item_change_font_size),
                action = { visible = visible != true }
            )

            FontSizeWidget(state = visible, viewModel = viewModel, scope = scope)

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