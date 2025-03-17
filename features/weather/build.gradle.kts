plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.javalenciab90.home"
    resourcePrefix = "weather_"

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":plataform"))
    implementation(project(":design-system"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.navigation)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}