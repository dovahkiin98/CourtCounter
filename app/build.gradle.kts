import java.text.SimpleDateFormat

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
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

    compileSdkVersion(30)

    defaultConfig {
        applicationId = "net.inferno.courtcounter"

        minSdkVersion(21)
        targetSdkVersion(30)

        vectorDrawables.useSupportLibrary = true
        buildFeatures {
            compose = true
        }

        versionCode = 1
        versionName = "1.0"
    }

    flavorDimensions("dev")

    productFlavors {
        maybeCreate("dev")
        getByName("dev") {
            dimension = "dev"

            minSdkVersion(28)

            versionNameSuffix = "-dev" + "-" + SimpleDateFormat("dd-MM-yyyy").format(System.currentTimeMillis())

            buildConfigField("boolean", "DEV", "true")
        }
        maybeCreate("deploy")
        getByName("deploy") {
            dimension = "dev"

            minSdkVersion(21)

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
        freeCompilerArgs = freeCompilerArgs + arrayOf(
            "-Xallow-jvm-ir-dependencies",
            "-Xskip-prerelease-check",
            "-Xopt-in=kotlin.RequiresOptIn"
        )
    }

    composeOptions {
//        kotlinCompilerVersion = Versions.kotlin
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    //region Local
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //endregion

    //region Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    //endregion

    //region AndroidX
    implementation("androidx.appcompat:appcompat:${Versions.appCompat}")
    implementation("androidx.core:core-ktx:${Versions.core}")
    implementation("androidx.fragment:fragment-ktx:${Versions.fragment}")
    //endregion

    //region UI Components
    implementation("androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}")
    //endregion

    //region Lifecycle Components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}")
    //endregion

    //region Google
    implementation("com.google.android.material:material:${Versions.material}")
    //endregion

    //region Compose
    implementation("androidx.compose.ui:ui:${Versions.compose}")
    implementation("androidx.compose.material:material:${Versions.compose}")
    implementation("androidx.ui:ui-tooling:${Versions.compose}")
    implementation("androidx.compose.runtime:runtime-livedata:${Versions.compose}")
    //endregion
}