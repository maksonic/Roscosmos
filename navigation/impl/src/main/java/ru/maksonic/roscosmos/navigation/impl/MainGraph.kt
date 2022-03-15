package ru.maksonic.roscosmos.navigation.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.maksonic.roscosmos.navigation.api.MainRoute
import ru.maksonic.roscosmos.navigation.api.SettingsRoute
import ru.maksonic.roscosmos.screen.main.MainScreen

/**
 * @Author: maksonic on 12.03.2022
 */
fun NavGraphBuilder.mainGraph(navController: NavHostController) {

    navigation(
        route = MainRoute.route,
        startDestination = MainRoute.MainScreen.route
    ) {
        composable(route = MainRoute.MainScreen.route) {
            MainScreen(showSettings = {
                navController.navigate(route = SettingsRoute.SettingsScreen.route)
            })
        }
    }
}
