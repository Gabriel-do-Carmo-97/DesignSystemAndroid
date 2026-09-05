// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.detekt) apply false
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    
    afterEvaluate {
        extensions.findByName("detekt")?.let {
            val detektExt = it as? io.gitlab.arturbosch.detekt.extensions.DetektExtension
            detektExt?.buildUponDefaultConfig = true
            detektExt?.ignoreFailures = true
        }
    }
}
