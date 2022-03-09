import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * @Author: maksonic on 09.03.2022
 */
fun PluginDependenciesSpec.androidApp(): PluginDependencySpec =
    id("com.android.application")

fun PluginDependenciesSpec.androidLibrary(): PluginDependencySpec =
    id("com.android.library")

fun PluginDependenciesSpec.googleServices(): PluginDependencySpec =
    id("com.google.gms.google-services")

fun PluginDependenciesSpec.kotlinAndroid(): PluginDependencySpec =
    kotlin("android")

fun PluginDependenciesSpec.hilt(): PluginDependencySpec =
    id("dagger.hilt.android.plugin")

fun PluginDependenciesSpec.kapt(): PluginDependencySpec =
    id("kotlin-kapt")

fun PluginDependenciesSpec.parcelize(): PluginDependencySpec =
    id("kotlin-parcelize")