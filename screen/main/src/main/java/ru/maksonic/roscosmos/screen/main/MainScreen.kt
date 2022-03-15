package ru.maksonic.roscosmos.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.maksonic.roscosmos.navigation.api.MainRoute
import ru.maksonic.roscosmos.shared.ui.R
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.component.IconButtonPrimary

/**
 * @Author: maksonic on 09.03.2022
 */
@Composable
fun MainScreen(
    showSettings: () -> Unit
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        topBar = { MainTopAppBar(showSettings) },
        backgroundColor = RCTheme.color.background,
        bottomBar = { MainBottomNavigationBar(navController) }
    ) {
        NavHost(navController, startDestination = MainRoute.NewsScreen.route) {
            mainBottomGraph(navController)
        }
    }
}

@Composable
private fun MainTopAppBar(
    showSettings: () -> Unit
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(id = RCTheme.image.roscosmosToolbarLogo),
                    contentDescription = null
                )
            }
        },
        backgroundColor = RCTheme.color.background,
        elevation = 0.dp,
        actions = {
            IconButtonPrimary(onClick = showSettings) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = null,
                    tint = RCTheme.color.primaryText
                )
            }
        }
    )
}

@Composable
private fun MainBottomNavigationBar(navController: NavController) {
    val items = listOf(
        MainRoute.NewsScreen,
        MainRoute.VideosScreen,
        MainRoute.SpaceScreen
    )

    BottomAppBar(
        backgroundColor = RCTheme.color.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: MainRoute.NewsScreen.route
        for (screen in items) {
            val label = stringResource(screen.labelId)
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(
                            id = if (currentRoute == screen.route) {
                                screen.selectedIcon
                            } else {
                                screen.unselectedIcon
                            }
                        ), label
                    )
                },
                label = { Text(label) },
                alwaysShowLabel = true,
                selected = currentRoute == screen.route,
                selectedContentColor = RCTheme.color.primary,
                unselectedContentColor = RCTheme.color.secondaryVariant,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(checkNotNull(navController.graph.startDestinationRoute)) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

fun NavGraphBuilder.mainBottomGraph(
    navController: NavHostController
) {

    composable(MainRoute.NewsScreen.route) {
        NewsScreen()
    }
    composable(MainRoute.VideosScreen.route) {
        VideosScreen()
    }
    composable(MainRoute.SpaceScreen.route) {
        SpaceScreen()
    }
}
