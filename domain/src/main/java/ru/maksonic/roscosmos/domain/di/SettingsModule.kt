package ru.maksonic.roscosmos.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.maksonic.roscosmos.core.settings.ThemeSetting
import ru.maksonic.roscosmos.domain.settings.SetupUiThemeUseCase
import ru.maksonic.roscosmos.domain.settings.SettingsInteractor
import javax.inject.Singleton

/**
 * @Author: maksonic on 16.03.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object SettingsModule {

    @Singleton
    @Provides
    fun provideGetThemeUseCase(themeSetting: ThemeSetting): SettingsInteractor.SetupUiThemeUseCase =
        SetupUiThemeUseCase(themeSetting)
}