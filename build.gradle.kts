buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath(kotlin("gradle-plugin", Versions.kotlin))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}