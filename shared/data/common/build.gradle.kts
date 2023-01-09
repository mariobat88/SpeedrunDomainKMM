plugins {
    id("kmm.library")
    kotlin("plugin.serialization") version "1.4.32"
}

kotlin {
    cocoapods {
        summary = "Data common module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "common"
            isStatic = false
        }
    }

    sourceSets {
        val commonMain by getting{
            dependencies{
                implementation(libs.io.ktor.client.serialization.json)
            }
        }
    }
}
