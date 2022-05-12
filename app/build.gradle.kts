import java.text.SimpleDateFormat

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    signingConfigs {
        create("testKey") {
            keyAlias = "key0"
            keyPassword = "123456"
            storeFile = file("../testkey.jks")
            storePassword = "123456"
        }
    }

    buildToolsVersion = "33.0.0-rc4"
    compileSdk = 32

    defaultConfig {
        applicationId = "net.inferno.courtcounter"

        targetSdk = 32

        vectorDrawables.useSupportLibrary = true
        buildFeatures {
            compose = true
        }

        versionCode = 1
        versionName = "1.0"
    }

    flavorDimensions += setOf("dev")

    productFlavors {
        maybeCreate("dev")
        getByName("dev") {
            dimension = "dev"

            minSdk = 30

            versionNameSuffix = "-dev" + "-" + SimpleDateFormat("dd-MM-yyyy").format(System.currentTimeMillis())

            buildConfigField("boolean", "DEV", "true")
        }
        maybeCreate("deploy")
        getByName("deploy") {
            dimension = "dev"

            minSdk = 23

            buildConfigField("boolean", "DEV", "false")
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
        }

        maybeCreate("preRelease")
        getByName("preRelease") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = true
            versionNameSuffix = "-" + SimpleDateFormat("dd-MM-yyyy").format(System.currentTimeMillis())

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs["testKey"]
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs["testKey"]
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + arrayOf(
            "-Xallow-jvm-ir-dependencies",
            "-Xskip-prerelease-check",
            "-Xopt-in=kotlin.RequiresOptIn"
        )
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    //region Kotlin
    implementation(kotlin("stdlib-jdk8", Versions.kotlin))
    //endregion

    //region AndroidX
    implementation("androidx.appcompat:appcompat:${Versions.appCompat}")
    implementation("androidx.core:core-ktx:${Versions.core}")
    implementation("androidx.activity:activity-ktx:${Versions.activity}")

    implementation("androidx.activity:activity-compose:${Versions.activity}")
    //endregion

    //region Google
    implementation("com.google.android.material:material:${Versions.material}")
    //endregion

    //region Compose
    implementation("androidx.compose.ui:ui:${Versions.compose}")
    implementation("androidx.compose.material:material:${Versions.compose}")
    implementation("androidx.compose.material3:material3:${Versions.composeMaterial3}")
    implementation("androidx.compose.ui:ui-tooling:${Versions.compose}")
    //endregion

    //region Debug
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.compose}")
    debugImplementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")
    //endregion
}