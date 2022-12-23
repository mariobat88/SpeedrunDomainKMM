package android

import com.android.build.gradle.LibraryExtension
import com.codebox.speedrun.domain.app
import com.codebox.speedrun.domain.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused", "UnstableApiUsage")
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = app.targetSdk
            }
        }
    }
}
