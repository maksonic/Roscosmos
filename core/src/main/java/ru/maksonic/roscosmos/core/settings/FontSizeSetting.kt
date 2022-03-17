package ru.maksonic.roscosmos.core.settings

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import ru.maksonic.roscosmos.core.provider.ResourceProvider
import javax.inject.Inject

/**
 * @Author: maksonic on 17.03.2022
 */
interface FontSizeSetting {
    suspend fun saveFont(font: Float)
    suspend fun getFont(): MutableState<Float>
    var fontSize: MutableState<Float>

    class BaseFontSizeSetting @Inject constructor(
        val context: Context,
        private val rp: ResourceProvider
    ) : FontSizeSetting {
        companion object {
            private val KEY_PREFS_FONT_SIZE = floatPreferencesKey("prefs_setting_font_size")
            const val DEF_FONT_SIZE = 20f
        }

        override var fontSize: MutableState<Float> = mutableStateOf(DEF_FONT_SIZE)

        override suspend fun saveFont(font: Float) {
            rp.apply {
                context.datastore.edit { preferences ->
                    preferences[KEY_PREFS_FONT_SIZE] = font
                }
            }
        }

        override suspend fun getFont(): MutableState<Float> {
            rp.apply {
                context.datastore.data.map { preferences ->
                    preferences[KEY_PREFS_FONT_SIZE] ?: DEF_FONT_SIZE
                }.collect {
                    fontSize.value = it
                }
                return fontSize
            }
        }
    }
}