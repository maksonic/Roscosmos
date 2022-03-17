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
    implementation(project(Module.CORE))
    implementation(project(Module.DOMAIN))
    implementation(project(Module.Shared.UI))
    implementation(project(Module.Navigation.API))
    implementation(project(Screen.NEWS))
    implementation(project(Screen.VIDEOS))
    implementation(project(Screen.SPACE))
    implementation(Lib.Accompanist.NAVIGATION_ANIMATION)
    implementation(Lib.Lifecycle.VIEWMODEL_SCOPE)
    implementation(Lib.Compose.UI)
    implementation(Lib.Compose.MATERIAL)
    implementation(Lib.Compose.UI_PREVIEW)
    implementation(Lib.Dagger.VIEWMODEL)
    testImplementation(Lib.Test.Junit.JUNIT)
    androidTestImplementation(Lib.Test.Junit.EXT)
    androidTestImplementation(Lib.Test.Compose.UI)
    debugImplementation(Lib.Test.Compose.UI_TOOLING)
    implementation(Lib.Dagger.HILT)
    kapt(Lib.Dagger.COMPILER)
}