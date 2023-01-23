plugins {
    id("kmm.library")
}

kotlin {
    cocoapods {
        summary = "Foundation module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "foundation"
            isStatic = false
            linkerOpts.add("-lsqlite3")
        }
    }
    
    sourceSets {
        val commonMain by getting{
            dependencies{
                implementation(libs.kotlinx.coroutines)
            }
        }
        val androidMain by getting{
            dependencies{
                api(libs.androidx.lifecycle.lifecycle.viewmodel)
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.compose.runtime)
                implementation(libs.androidx.navigation.compose)
                implementation(libs.androidx.lifecycle.lifecycle.viewmodel.ktx)
                implementation(libs.androidx.lifecycle.compose.runtime)
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
            dependencies{
                implementation(libs.org.jetbrains.kotlin.kotlin.stdlib)
            }
        }
    }
}
