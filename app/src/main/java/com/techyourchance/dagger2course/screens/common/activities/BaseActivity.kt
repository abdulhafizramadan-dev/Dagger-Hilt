package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.composition.ActivityCompositionRoot
import com.techyourchance.dagger2course.common.composition.PresentationCompositionRoot

abstract class BaseActivity: AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).compositionRoot

    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }

    val compositionRoot: PresentationCompositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }
}