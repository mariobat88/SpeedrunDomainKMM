plugins {
    id("kmm.library")
}

kotlin {
    cocoapods {
        summary = "Framework module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "framework"
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
                implementation(libs.androidx.lifecycle.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.lifecycle.viewmodel.ktx)
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
