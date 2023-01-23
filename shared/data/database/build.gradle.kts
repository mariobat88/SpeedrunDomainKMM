plugins {
    id("kmm.library")
    id("com.squareup.sqldelight")
}

kotlin {
    cocoapods {
        summary = "Database module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "database"
            isStatic = false
            linkerOpts.add("-lsqlite3")
        }
    }

    sourceSets {
        val commonMain by getting{
            dependencies {
                implementation(libs.com.squareup.sqldelight.runtime)
                implementation(libs.com.squareup.sqldelight.coroutines.extensions)
            }
        }
        val androidMain by getting{
            dependencies {
                implementation(libs.com.squareup.sqldelight.android.driver)
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
                implementation(libs.com.squareup.sqldelight.native.driver)
            }
        }
    }
}

sqldelight{
    database("SpeedrunDomainDatabase"){
        packageName = "com.codebox.speedrun.domain.data.database"
    }
}
