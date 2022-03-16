package ru.maksonic.roscosmos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ru.maksonic.roscosmos.core.settings.AppTheme
import ru.maksonic.roscosmos.core.settings.ThemeSetting
import ru.maksonic.roscosmos.navigation.api.MainRoute
import ru.maksonic.roscosmos.navigation.impl.mainGraph
import ru.maksonic.roscosmos.navigation.impl.settingsGraph
import ru.maksonic.roscosmos.screen.main.mainBottomGraph
import ru.maksonic.roscosmos.shared.ui.theme.BrandTheme
import ru.maksonic.roscosmos.shared.ui.theme.MainTheme
import ru.maksonic.roscosmos.shared.ui.theme.RCTheme
import ru.maksonic.roscosmos.shared.ui.theme.color.InitSystemComponentsColor
import javax.inject.Inject

/**
 * @Author: maksonic on 09.03.2022
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var themeSetting: ThemeSetting

    @OptIn(
        ExperimentalMaterialNavigationApi::class,
        androidx.compose.animation.ExperimentalAnimationApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val navController = rememberAnimatedNavController(bottomSheetNavigator)
            val darkMode = remember { mutableStateOf(false) }
            val systemTheme = isSystemInDarkTheme()
            val systemController = rememberSystemUiController()
            val appTheme = themeSetting.themeStream.collectAsState()
            val roscosmosTheme: @Composable (
                content: @Composable () -> Unit
            ) -> Unit = when (appTheme.value) {
                AppTheme.RC_BRAND -> { content -> BrandTheme(content = content) }
                AppTheme.RC_DARK -> { content -> MainTheme(darkTheme = true, content) }
                AppTheme.RC_LIGHT -> { content -> MainTheme(content = content) }
                AppTheme.RC_SYSTEM -> { content -> MainTheme(systemTheme, content) }
            }

            roscosmosTheme.invoke() {
                val backgroundColor = RCTheme.color.background
                InitSystemComponentsColor(systemTheme, appTheme, systemController, backgroundColor)

                ModalBottomSheetLayout(bottomSheetNavigator = bottomSheetNavigator) {

                    Scaffold(
                        backgroundColor = backgroundColor
                    ) {

                        AnimatedNavHost(
                            navController = navController,
                            startDestination = MainRoute.route,
                            enterTransition = { fadeIn() },
                            exitTransition = { fadeOut() },
                            popEnterTransition = { fadeIn() },
                            popExitTransition = { fadeOut() }) {
                            mainGraph(navController)
                            settingsGraph(
                                navController,
                                onThemeSelected = { theme -> themeSetting.theme = theme },
                                darkMode = darkMode,
                                themeSetting = themeSetting
                            )
                            mainBottomGraph(navController)
                        }
                    }
                }
            }
        }
    }
}

