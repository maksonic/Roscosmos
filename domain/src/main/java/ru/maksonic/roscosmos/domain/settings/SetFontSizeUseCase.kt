package ru.maksonic.roscosmos.domain.settings

import androidx.compose.runtime.MutableState
import ru.maksonic.roscosmos.core.settings.FontSizeSetting
import javax.inject.Inject

/**
 * @Author: maksonic on 17.03.2022
 */
class SetFontSizeUseCase @Inject constructor(
    private val fontSizeSetting: FontSizeSetting
) : SettingsInteractor.FontSize {

    override suspend fun saveFont(font: Float) = fontSizeSetting.saveFont(font)
    override suspend fun getFont(): MutableState<Float> = fontSizeSetting.getFont()
    override var currentFontSize: MutableState<Float> = fontSizeSetting.fontSize
}