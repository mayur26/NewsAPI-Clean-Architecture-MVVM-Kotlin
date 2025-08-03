plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    kotlin("kapt")
    kotlin("plugin.parcelize")
}

android {
    namespace = "com.mayur.androidcleanarchitecturemvvm"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mayur.androidcleanarchitecturemvvm"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isDebuggable = true
            buildConfigField("String", "API_BASE_URL", "\"https://app.navtekmarine.com/marineiq/api/\"")  // Example of using BuildConfig fields
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "API_BASE_URL", "\"https://api.release.com/\"")  // Example of using BuildConfig fields
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
        buildConfig = true  // Enable BuildConfig generation
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.android.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.compose.material.icons.extended)

    // ConstraintLayout
    implementation(libs.androidx.constraintlayout)

    // Lifecycle Libraries
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    implementation(libs.androidx.lifecycle.common.java8)

    // Navigation Libraries
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.hilt.navigation.compose)

    // Retrofit2 Libraries
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // OkHttp3 Libraries
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    implementation(libs.spinkit)

//    implementation(libs.htextview.base)

    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.viewpager2)

    // Image loading - Coil
    implementation(libs.coil.compose)

    implementation(libs.security.crypto)

    implementation(libs.hilt.android)  // Hilt Android dependency
    kapt(libs.hilt.compiler)

    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}