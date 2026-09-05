plugins {
    `kotlin-dsl`
}

group = "br.com.wgc.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "wgc.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}
