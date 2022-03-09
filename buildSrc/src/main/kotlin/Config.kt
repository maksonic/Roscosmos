import org.gradle.api.JavaVersion

/**
 * @Author: maksonic on 09.03.2022
 */
object Config {
    const val composeVersion = "1.2.0-alpha04"
    const val kotlinVersion = "1.6.10"
    const val appId = "ru.maksonic.roscosmos"
    const val compileSdk = 32
    const val targetSdk = 32
    const val minSdk = 23
    const val versionName = "1.0"
    const val versionCode = 1
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val androidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"

    val javaVersion = JavaVersion.VERSION_11
    const val jvmTarget = "11"
}