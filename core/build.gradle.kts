plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "br.com.wgc.core_ds"
    compileSdk = 37

    defaultConfig {
        minSdk = 29
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        compilerOptions {
            jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "br.com.wgc"
            artifactId = "core"
            version = project.findProperty("VERSION_NAME")?.toString()
                ?: System.getenv("VERSION_NAME")
                ?: "1.0.0-SNAPSHOT"

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("WGC Design System Core")
                description.set("Core design tokens, colors, typography, dimensions and shapes for WGC Design System")
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
