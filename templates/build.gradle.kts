plugins {
    id("wgc.android.library")
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
    alias(libs.plugins.screenshot)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "br.com.wgc.design_system.templates"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {
    implementation(project(":components"))
    implementation(project(":core"))
    implementation(libs.androidx.core.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.coil.compose)
    implementation(libs.kotlinx.serialization.core)

    testImplementation(libs.mockk)
    androidTestImplementation(libs.mockk.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    screenshotTestImplementation(libs.screenshot.validation.api)
    screenshotTestImplementation(libs.androidx.ui.tooling)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "br.com.wgc"
            artifactId = "templates"
            version = project.findProperty("VERSION_NAME")?.toString()
                ?: System.getenv("VERSION_NAME")
                ?: "1.0.0-SNAPSHOT"

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("WGC Design System Templates")
                description.set("Full screen templates, decoupled layouts and patterns for WGC Design System")
                url.set("https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid")
                licenses {
                    license {
                        name.set("Apache-2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    }
                }
                developers {
                    developer {
                        id.set("wgc")
                        name.set("WGC Android Team")
                        email.set("dev@wgc.com.br")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid.git")
                    developerConnection.set("scm:git:ssh://github.com:Gabriel-do-Carmo-97/DesignSystemAndroid.git")
                    url.set("https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid")
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Gabriel-do-Carmo-97/DesignSystemAndroid")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
