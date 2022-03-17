package ru.maksonic.roscosmos.domain.settings

import androidx.compose.runtime.MutableState
import ru.maksonic.roscosmos.core.settings.AppTheme

/**
 * @Author: maksonic on 16.03.2022
 */
interface SettingsInteractor {

    interface SetupUiThemeUseCase {
        fun setSystemTheme(): AppTheme
        fun setLightTheme(): AppTheme
        fun setDarkTheme(isDarkMode: MutableState<Boolean>): AppTheme
        fun setBrandTheme(): AppTheme
    }

    interface FontSize {
        suspend fun saveFont(font: Float)
        suspend fun getFont(): MutableState<Float>
        var currentFontSize: MutableState<Float>
    }
}