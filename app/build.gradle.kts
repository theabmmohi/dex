plugins {
    id("com.android.application")
}

android {
    namespace = "com.theabmmohi.dex"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.theabmmohi.dex"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
