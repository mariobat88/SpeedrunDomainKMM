plugins {
    id("kmm.library")
}

kotlin {
    cocoapods {
        summary = "DI module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "di"
            isStatic = false
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //implementation(projects.shared.core.fra)
                implementation(projects.shared.data.database)
                implementation(projects.shared.data.datasource)
                implementation(projects.shared.data.repo)
                implementation(projects.shared.networking.api)
            }
        }
    }
}
