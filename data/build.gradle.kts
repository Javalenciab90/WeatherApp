plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.javalenciab90.data"

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":plataform"))
    implementation(project(":service"))
    implementation(project(":networkmodels"))
    api(project(":domain"))

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    implementation(libs.square.retrofit2)
    implementation(libs.square.okhttp3)
    implementation(libs.square.okhttp3.loggingInterceptor)
    implementation(libs.square.converter.kotlinxSerialization)
    implementation(libs.kotlinx.serialization.json)

    // Room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)
    implementation(libs.gson)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}