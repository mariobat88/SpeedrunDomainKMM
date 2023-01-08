
plugins {
    id("kmm.library")
}
kotlin {
    cocoapods {
        summary = "Repository module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "repo"
            isStatic = false
        }
    }

    sourceSets {
        val commonMain by getting{
            dependencies {
                implementation(projects.shared.data.common)
                implementation(libs.kotlinx.coroutines)
            }
        }
    }
}
