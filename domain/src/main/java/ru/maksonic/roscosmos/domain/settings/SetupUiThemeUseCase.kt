package ru.maksonic.roscosmos.domain.settings

import ru.maksonic.roscosmos.core.settings.AppTheme
import ru.maksonic.roscosmos.core.settings.ThemeSetting
import javax.inject.Inject
import androidx.compose.runtime.MutableState

/**
 * @Author: maksonic on 16.03.2022
 */
class SetupUiThemeUseCase @Inject constructor(
    private val themeSetting: ThemeSetting
) : SettingsInteractor.SetupUiThemeUseCase {

    override fun setSystemTheme(): AppTheme {
        val theme = themeSetting.setupTheme(AppTheme.RC_SYSTEM.ordinal)
        themeSetting.theme = theme
        return theme
    }

    override fun setLightTheme(): AppTheme {
        val theme = themeSetting.setupTheme(AppTheme.RC_LIGHT.ordinal)
        themeSetting.theme = theme
        return theme
    }

    override fun setDarkTheme(isDarkMode: MutableState<Boolean>): AppTheme {
        isDarkMode.value = true
        val theme = themeSetting.setupTheme(AppTheme.RC_DARK.ordinal)
        themeSetting.theme = theme
        return theme
    }

    override fun setBrandTheme(): AppTheme {
        val theme = themeSetting.setupTheme(AppTheme.RC_BRAND.ordinal)
        themeSetting.theme = theme
        return theme
    }
}