package ru.maksonic.roscosmos.screen.settings

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.maksonic.roscosmos.domain.settings.SetFontSizeUseCase
import ru.maksonic.roscosmos.domain.settings.SettingsInteractor
import javax.inject.Inject

/**
 * @Author: maksonic on 16.03.2022
 */
@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getThemeUseCase: SettingsInteractor.SetupUiThemeUseCase,
    private val fontSizeUseCase: SetFontSizeUseCase
) : ViewModel() {

    var scalableTextSize = fontSizeUseCase.currentFontSize

    init {
        viewModelScope.launch {
            fontSizeUseCase.getFont()
        }
    }
    suspend fun save(font: Float) = fontSizeUseCase.saveFont(font)

    fun setSystemTheme() = getThemeUseCase.setSystemTheme()
    fun setLightTheme() = getThemeUseCase.setLightTheme()
    fun setDarkTheme(isDarkMode: MutableState<Boolean>) = getThemeUseCase.setDarkTheme(isDarkMode)
    fun setBrandTheme() = getThemeUseCase.setBrandTheme()
}