plugins {
    alias(libs.plugins.android.library)
    id("org.gradle.maven-publish")
}

android {
    namespace = "com.andy.ffmpeg_wrapper"
    compileSdk = 34
    
    defaultConfig {
        minSdk = 24
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(files("libs/ffmpeg-kit-https-6.0-2.aar"))
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}




    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.andy"
                artifactId = "ffmpegkit"
                version = "6.0.2"
                
                artifact("$buildDir/outputs/aar/${project.name}-release.aar")
                
                pom {
                    name.set("ffmpeg-wrapper")
                    description.set("Wrapped ffmpeg-kit prebuilt AAR")
                    url.set("https://https://github.com/zhonjianxiong/ffmpeg-wrapper")
                    licenses {
                        license {
                            name.set("ffmpeg-wrapper")
                            url.set("https://opensource.org/licenses/ffmpeg-wrapper")
                        }
                    }
                }
            }
        }
        
        repositories {
            maven {
                url = uri("$buildDir/repo")
            }
        }
    }
