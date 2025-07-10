plugins {
    alias(libs.plugins.android.application)
    id("org.gradle.maven-publish")
}

android {
    namespace = "com.andy.ffmpeg_kit_https"
    compileSdk = 34
    
    defaultConfig {
        applicationId = "com.andy.ffmpeg_kit_https"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "6.0.2"
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(files("libs/ffmpeg-kit-https-6.0-2.aar"))
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.andy.ffmpeg_kit_https"
                artifactId = "ffmpegkit"
                version = "6.0.2"
                
                // 使用默认输出的 aar 文件
                artifact("$buildDir/outputs/aar/${project.name}-release.aar")
                
                // 可选：生成 POM 文件
                pom {
                    name.set("FFmpeg Kit")
                    description.set("FFmpeg Kit AAR Wrapper")
                    url.set("https://github.com/zhonjianxiong/ffmpeg-wrapper")
                    licenses {
                        license {
                            name.set("MIT License")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }
                    developers {
                        developer {
                            id.set("tanersener")
                            name.set("Taner Sener")
                            email.set("zhonjianxiong222@gmail.com")
                        }
                    }
                    scm {
                        url.set("https://github.com/zhonjianxiong/ffmpeg-wrapper")
                    }
                }
            }
        }
    }
}

