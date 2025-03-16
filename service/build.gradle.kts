import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

val secretsFile = rootProject.file("secrets.properties")
val properties = Properties()
secretsFile.inputStream().use { properties.load(it) }

val weatherStackKey: String = properties.getProperty("WEATHER_STACK_API")

android {
    namespace = "com.javalenciab90.service"

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "WEATHER_STACK_API", "\"weatherStackKey\"")
        buildConfigField("String", "URL_BASE", "\"http://api.weatherstack.com/\"")
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":plataform"))

    // Retrofit
    implementation(libs.square.retrofit2)
    implementation(libs.square.okhttp3)
    implementation(libs.square.okhttp3.loggingInterceptor)
    implementation(libs.square.converter.kotlinxSerialization)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}