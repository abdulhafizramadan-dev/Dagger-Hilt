package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.dependencyinjection.app.AppComponent
import com.techyourchance.dagger2course.common.dependencyinjection.app.AppModule
import com.techyourchance.dagger2course.common.dependencyinjection.app.DaggerAppComponent

class MyApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}