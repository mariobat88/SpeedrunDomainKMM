plugins {
    id("kmm.library")
}

kotlin {
    cocoapods {
        summary = "Test feature module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "test"
            isStatic = false
        }
    }

    sourceSets {
        val commonMain by getting{
            dependencies{
                implementation(projects.shared.core.base)
                implementation(projects.shared.data.repo)
                implementation(projects.shared.di)
                implementation(libs.kotlinx.coroutines)
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
