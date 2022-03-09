plugins {
    androidLibrary()
    kotlinAndroid()
    hilt()
    kapt()
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        testInstrumentationRunner = Config.androidJunitRunner
    }

    buildTypes {
        getByName(BuildType.TYPE) {
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.composeVersion
    }

    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }

    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {
    implementation(project(Module.Navigation.API))
    implementation(project(Screen.MAIN))
    implementation(Lib.Accompanist.NAVIGATION_MATERIAL)
    implementation(Lib.Compose.MATERIAL)
    implementation(Lib.Compose.NAVIGATION)
    implementation(Lib.Dagger.VIEWMODEL)
    implementation(Lib.Dagger.HILT)
    kapt(Lib.Dagger.COMPILER)
}