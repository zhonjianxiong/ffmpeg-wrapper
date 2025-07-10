plugins {
    alias(libs.plugins.android.application)
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

