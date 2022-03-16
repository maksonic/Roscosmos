/**
 * @Author: maksonic on 09.03.2022
 */
object Lib {
    private const val composeVersion = Config.composeVersion

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.4.1"
        const val ANNOTATION = "androidx.annotation:annotation:1.3.0"
        const val CORE_KTX = "androidx.core:core-ktx:1.7.0"
        const val MATERIAL = "com.google.android.material:material:1.5.0"
    }

    object Accompanist {
        private const val version = "0.24.3-alpha"
        const val PAGER = "com.google.accompanist:accompanist-pager:$version"
        const val NAVIGATION_ANIMATION = "com.google.accompanist:accompanist-navigation-animation:$version"
        const val NAVIGATION_MATERIAL = "com.google.accompanist:accompanist-navigation-material:$version"
        const val SYSTEM_UI = "com.google.accompanist:accompanist-systemuicontroller:$version"
    }

    object Compose {
        const val ACTIVITY = "androidx.activity:activity-compose:1.4.0"
        const val COMPILER = "androidx.compose.compiler:compiler:$composeVersion"
        const val FOUNDATION = "androidx.compose.foundation:foundation:$composeVersion"
        const val MATERIAL = "androidx.compose.material:material:$composeVersion"
        const val UI = "androidx.compose.ui:ui:$composeVersion"
        const val UI_PREVIEW = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    }

    object Dagger {
        private const val version = "2.41"
        const val HILT = "com.google.dagger:hilt-android:$version"
        const val COMPILER = "com.google.dagger:hilt-compiler:$version"
        const val VIEWMODEL = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Lifecycle {
        const val RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.0-alpha02"
    }

    object Test {
        object Compose {
            const val UI = "androidx.compose.ui:ui-test-junit4:$composeVersion"
            const val UI_TOOLING = "androidx.compose.ui:ui-tooling:$composeVersion"
        }

        object Espresso {
            private const val version = "3.4.0"
            const val CORE = "androidx.test.espresso:espresso-core:$version"
        }

        object Junit {
            const val JUNIT = "junit:junit:4.13"
            const val EXT = "androidx.test.ext:junit:1.1.3"

        }
    }
}