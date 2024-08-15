package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyinjection.ActivityCompositionRoot
import com.techyourchance.dagger2course.common.dependencyinjection.Injector
import com.techyourchance.dagger2course.common.dependencyinjection.PresentationCompositionRoot

abstract class BaseActivity: AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).compositionRoot

    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }

    private val compositionRoot: PresentationCompositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }

    protected val injector get() = Injector(compositionRoot)
}