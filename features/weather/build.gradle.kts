plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
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
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":common-ui"))

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    implementation(libs.coil.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.navigation)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}