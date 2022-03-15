package ru.maksonic.roscosmos.navigation.impl

import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.maksonic.roscosmos.core.settings.AppTheme
import ru.maksonic.roscosmos.core.settings.ThemeSetting
import ru.maksonic.roscosmos.navigation.api.SettingsRoute
import ru.maksonic.roscosmos.screen.settings.SettingsScreen

/**
 * @Author: maksonic on 12.03.2022
 */
fun NavGraphBuilder.settingsGraph(
    navController: NavHostController,
    darkMode: MutableState<Boolean>,
    themeSetting: ThemeSetting,
    onThemeSelected: (AppTheme) -> Unit
) {

    navigation(
        route = SettingsRoute.route,
        startDestination = SettingsRoute.SettingsScreen.route
    ) {
        composable(route = SettingsRoute.SettingsScreen.route) {
            SettingsScreen(
                toolbarBackPressed = { navController.popBackStack() },
                onThemeSelected = onThemeSelected,
                themeSetting = themeSetting,
                darkMode = darkMode
            )
        }
    }
}