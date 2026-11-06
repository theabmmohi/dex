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

    signingConfigs {
        create("release") {
            val ksFile = rootProject.file("theabmmohi.keystore")
            val ksPass = System.getenv("KEYSTORE_PASS")
            if (ksFile.exists() && ksPass != null) {
                storeFile = ksFile
                storePassword = ksPass
                keyAlias = "dex"
                keyPassword = ksPass
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
