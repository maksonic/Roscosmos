package ru.maksonic.roscosmos.screen.space

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.maksonic.roscosmos.domain.settings.SetFontSizeUseCase
import javax.inject.Inject

/**
 * @Author: maksonic on 17.03.2022
 */
@HiltViewModel
class SpaceScreenViewModel @Inject constructor(
    private val fontSizeUseCase: SetFontSizeUseCase
) : ViewModel() {

    var scalableTextSize = fontSizeUseCase.currentFontSize

    init {
        viewModelScope.launch {
            fontSizeUseCase.getFont()
        }
    }

}
