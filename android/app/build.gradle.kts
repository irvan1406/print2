plugins {
    id("com.android.application")
}

android {
    namespace = "com.cetakpro.print"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.cetakpro.print"
        minSdk = 23
        targetSdk = 35
        versionCode = 7
        versionName = "1.4.2"

        buildConfigField("String", "WEB_APP_URL", "\"https://irvan1406.github.io/print2/\"")
    }

    buildFeatures {
        buildConfig = true
    }

    // Kunci tanda tangan TETAP (file vannota-update.p12 di folder android/) agar
    // setiap build bisa ditimpa di atas versi sebelumnya tanpa hapus data aplikasi.
    signingConfigs {
        create("updateTetap") {
            storeFile = file("../vannota-update.p12")
            storePassword = "vannota-update-2026"
            keyAlias = "vannota"
            keyPassword = "vannota-update-2026"
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("updateTetap")
        }
        release {
            signingConfig = signingConfigs.getByName("updateTetap")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("com.google.zxing:core:3.5.3")
    implementation("androidx.core:core:1.13.1")
}
