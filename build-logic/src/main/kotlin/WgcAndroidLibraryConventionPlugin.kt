import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class WgcAndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(DSBuildLogicConstants.ANDROID_LIBRARY_PLUGIN_ID)
            }

            extensions.configure<LibraryExtension> {
                compileSdk = DSBuildLogicConstants.COMPILE_SDK_VERSION

                defaultConfig {
                    minSdk = DSBuildLogicConstants.MIN_SDK_VERSION
                    testInstrumentationRunner = DSBuildLogicConstants.TEST_INSTRUMENTATION_RUNNER
                    consumerProguardFiles(DSBuildLogicConstants.CONSUMER_RULES_PRO)
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }

                packaging {
                    resources {
                        excludes += DSBuildLogicConstants.EXCLUDES
                    }
                }

                testOptions {
                    unitTests.isReturnDefaultValues = true
                }

                lint {
                    abortOnError = false
                    checkReleaseBuilds = false
                }
            }

            extensions.configure<KotlinAndroidProjectExtension> {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
    }
}
