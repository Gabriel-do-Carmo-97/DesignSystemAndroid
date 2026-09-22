plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.sonarqube) apply false
    alias(libs.plugins.dokka)
    alias(libs.plugins.binary.compatibility.validator)
    alias(libs.plugins.dependency.check)
    alias(libs.plugins.dependency.versions)
    alias(libs.plugins.license.report) apply false
}

apiValidation {
    ignoredProjects.addAll(listOf("app"))
}


subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    apply(plugin = "jacoco")
    apply(plugin = "org.jetbrains.dokka")
    
    afterEvaluate {
        extensions.findByName("detekt")?.let {
            val detektExt = it as? io.gitlab.arturbosch.detekt.extensions.DetektExtension
            detektExt?.buildUponDefaultConfig = true
            detektExt?.config?.setFrom(files("${rootProject.rootDir}/config/detekt/detekt.yml"))
            val projectBaseline = file("$projectDir/detekt-baseline.xml")
            if (projectBaseline.exists()) {
                detektExt?.baseline = projectBaseline
            } else {
                val baselineFile = file("${rootProject.rootDir}/config/detekt/baseline.xml")
                if (baselineFile.exists()) {
                    detektExt?.baseline = baselineFile
                }
            }
            detektExt?.ignoreFailures = false
        }
    }
}
