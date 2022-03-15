package ru.maksonic.roscosmos.core.provider

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.StringRes
import javax.inject.Inject

/**
 * @Author: maksonic on 15.03.2022
 */
interface ResourceProvider : PreferenceProvider {
    fun getString(@StringRes id: Int, vararg formatArgs: Any?): String

    class Base @Inject constructor(private val context: Context) : ResourceProvider {
        override fun getString(id: Int, vararg formatArgs: Any?) =
            context.getString(id, *formatArgs)

        override fun provideSharedPreferences(name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }
}