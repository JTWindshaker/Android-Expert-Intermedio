// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false

    //DaggerHilt
    id("com.google.dagger.hilt.android") version "2.48" apply false

    //Safeargs: Sirve para realizar la navegación segura
    id("androidx.navigation.safeargs.kotlin") version "2.7.1" apply false
}