plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.javalenciab90.detail"
    resourcePrefix = "weathermap_"

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":plataform"))
    implementation(project(":design-system"))
    implementation(project(":domain"))
    implementation(project(":common-ui"))

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    implementation(libs.maps.compose)
    implementation(libs.play.services.map)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.navigation)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}