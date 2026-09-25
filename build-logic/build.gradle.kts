plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compileOnly("com.android.tools.build:gradle:9.4.1")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.20")
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "wgc.android.library"
            implementationClass = "WgcAndroidLibraryConventionPlugin"
        }
    }
}
