package ru.maksonic.roscosmos.navigation.impl

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable
import ru.maksonic.roscosmos.navigation.api.SettingsRoute
import ru.maksonic.roscosmos.screen.settings.SettingsScreen

/**
 * @Author: maksonic on 12.03.2022
 */
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingsGraph(
    navController: NavHostController,
) {
    navigation(
        route = SettingsRoute.route,
        startDestination = SettingsRoute.SettingsScreen.route
    ) {
        composable(route = SettingsRoute.SettingsScreen.route) {
            SettingsScreen(
                toolbarBackPressed = { navController.popBackStack() },
                viewModel = hiltViewModel(),
            )
        }
    }
}