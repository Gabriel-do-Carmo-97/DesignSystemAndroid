plugins {
    id("wgc.android.library")
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "br.com.wgc.ds_navigation_flows"

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
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(project(":templates"))
    implementation(project(":components"))
    implementation(project(":core"))
    implementation(libs.androidx.core.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.core)

    testImplementation(libs.mockk)
    testImplementation(libs.junit)
    androidTestImplementation(libs.mockk.android)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "br.com.wgc"
            artifactId = "navigation-flows"
            version = project.findProperty("VERSION_NAME")?.toString()
                ?: System.getenv("VERSION_NAME")
                ?: "1.0.0-SNAPSHOT"

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("WGC Design System Navigation Flows")
                description.set("Decoupled navigation flows and graph coordinators for WGC Design System")
                url.set("https://github.com/Gabriel-do-Carmo-97/DesignSystemAndroid")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
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
