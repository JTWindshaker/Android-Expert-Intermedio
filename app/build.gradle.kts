plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //Plugins requeridos para que funcione daggerHilt
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

    //Plugín requerido para Safeargs
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.practica.horoscapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.practica.horoscapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    /**
     * buildTypes: Sirven para generar distintos ambientes en la aplicación. Se requiere de buildConfig = true en buildFeatures para que funcione.
     * Se pueden configurar las variables de entorno.
     */
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "appNameConfig", "HoroscApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro-production.vercel.app/\"")
        }

        getByName("debug") {
            isDebuggable = true
            resValue("string", "appNameConfig", "[DEBUG] HoroscApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    //viewBinding
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    //Se agrega si hay error en la jvm a la hora de crear el proyecto
    //    kotlin{
    //        jvmToolchain(8)
    //    }
}

dependencies {
    /**
     * NavComponent: Ambas dependencias requieren la misma versión, se recomienda crear un value que controle la integridad de esta regla
     */
    val navVersion = "2.7.6"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    /**
     * DaggerHilt(Herramienta para inyección de dependencia): automatiza y simplifica la gestión de dependencia.
     * kapt: proveedor que nos permite autogenerar código. DaggerHilt funciona creando clases ocultas para realizar la inyección.
     * para que kapt funcione, tenemos que ir al build gradle del proyecto e implementar la línea que allá está.
     * La versión debe ser la misma que la variable acá definida
     */
    val daggerHiltVersion = "2.48"
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")

    /**
     * Retrofit: Sirve para hacer llamadas API
     */
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    /**
     * Interceptor: Se encarga de obtener todos los resultados de las peticiones para poder manejarlas y gestionarlas
     */
    implementation("com.squareup.okhttp3:logging-interceptor:4.3.1")

    /**
     * Picaso: Sirve para trabajar con imagenes traídas de internet
     */
    implementation("com.squareup.picasso:picasso:2.8")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}