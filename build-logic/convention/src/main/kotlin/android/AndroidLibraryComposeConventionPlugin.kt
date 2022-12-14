package android

import com.android.build.gradle.LibraryExtension
import com.codebox.speedrun.domain.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

@Suppress("unused", "UnstableApiUsage")
class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("speedrun.domain.android.library")
            }

            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
            }

            val libs = extensions.getByType(VersionCatalogsExtension::class).named("libs")

            dependencies {
                val composeBom = platform(libs.findLibrary("androidx.compose.bom").get())
                add("implementation", composeBom)

                add("implementation", libs.findLibrary("androidx.compose.runtime").get())
            }
        }
    }
}
