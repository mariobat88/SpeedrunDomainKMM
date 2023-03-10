plugins {
    id("kmm.library")
    kotlin("plugin.serialization") version "1.4.32"
}

kotlin {
    cocoapods {
        summary = "Api module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "api"
            isStatic = false
            linkerOpts.add("-lsqlite3")
        }
    }

    sourceSets.apply {
        val commonMain by getting {
            dependencies {
                implementation(libs.io.ktor.client.core)
                implementation(libs.io.ktor.client.logging)
                implementation(libs.io.ktor.client.content.negotiation)
                implementation(libs.io.ktor.client.serialization.json)
                implementation(libs.io.github.aakira.napier)
                implementation(projects.shared.data.common)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.io.ktor.client.http)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.io.ktor.client.darwin)
            }
        }
    }
}
