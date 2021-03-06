package ru.maksonic.roscosmos.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.maksonic.roscosmos.core.provider.ResourceProvider
import ru.maksonic.roscosmos.core.settings.ThemeSetting
import ru.maksonic.roscosmos.core.settings.FontSizeSetting
import javax.inject.Singleton

/**
 * @Author: maksonic on 15.03.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun provideResourceProvider(@ApplicationContext context: Context): ResourceProvider =
        ResourceProvider.Base(context)

    @Singleton
    @Provides
    fun provideThemeSettings(rp: ResourceProvider): ThemeSetting =
        ThemeSetting.ThemeSettingPreference(rp)

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context, rp: ResourceProvider) : FontSizeSetting =
        FontSizeSetting.BaseFontSizeSetting(context = context, rp)
}