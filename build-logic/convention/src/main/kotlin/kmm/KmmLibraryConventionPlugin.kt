package kmm

import com.android.build.gradle.LibraryExtension
import com.codebox.speedrun.domain.app
import com.codebox.speedrun.domain.configureKotlinAndroid
import com.codebox.speedrun.domain.configureKotlinKmm
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused", "UnstableApiUsage")
class KmmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.jetbrains.kotlin.native.cocoapods")
                apply("com.android.library")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                configureKotlinKmm(this)
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = app.targetSdk
                sourceSets.getByName("main").manifest.srcFile("src\\androidMain\\AndroidManifest.xml")
            }
        }
    }
}
