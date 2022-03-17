package ru.maksonic.roscosmos.core.provider

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.StringRes
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import javax.inject.Inject

/**
 * @Author: maksonic on 15.03.2022
 */
interface ResourceProvider : PreferenceProvider {
    fun getString(@StringRes id: Int, vararg formatArgs: Any?): String
    val Context.datastore: DataStore<Preferences>

    class Base @Inject constructor(private val context: Context) : ResourceProvider {
        companion object {
            private const val DS_NAME = "datastore_settings"
        }

        override fun getString(id: Int, vararg formatArgs: Any?) =
            context.getString(id, *formatArgs)

        override fun provideSharedPreferences(name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

        override val Context.datastore by preferencesDataStore(name = DS_NAME)
    }
}