package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.composition.AppCompositionRoot

class MyApplication: Application() {

    lateinit var compositionRoot: AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        compositionRoot = AppCompositionRoot()
    }

}