package ru.maksonic.roscosmos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
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
import ru.maksonic.roscosmos.shared.ui.theme.*
import ru.maksonic.roscosmos.shared.ui.theme.color.InitSystemComponentsColor
import javax.inject.Inject

/**
 * @Author: maksonic on 09.03.2022
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var themeSetting: ThemeSetting

    @OptIn(ExperimentalMaterialNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val navController = rememberNavController(bottomSheetNavigator)
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

                    NavHost(navController, startDestination = MainRoute.route) {
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

