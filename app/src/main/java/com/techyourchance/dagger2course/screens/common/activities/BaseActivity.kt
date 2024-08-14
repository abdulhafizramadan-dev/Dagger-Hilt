package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.composition.ActivityCompositionRoot

abstract class BaseActivity: AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).compositionRoot

    val compositionRoot: ActivityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }
}