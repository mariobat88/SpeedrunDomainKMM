plugins {
    id("kmm.library")
}

kotlin {
    cocoapods {
        summary = "Game feature module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "game"
            isStatic = false
            linkerOpts.add("-lsqlite3")
        }
    }

    sourceSets {
        val commonMain by getting{
            dependencies{
                implementation(libs.kotlinx.coroutines)
                implementation(projects.shared.core.framework)
                implementation(projects.shared.core.navigation)
                implementation(projects.shared.core.wrapper.dispatchers)
                implementation(projects.shared.data.repo)
                implementation(projects.shared.di)
            }
        }
        val androidMain by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}
