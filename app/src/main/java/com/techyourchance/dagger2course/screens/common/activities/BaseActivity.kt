package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyinjection.ActivityComponent
import com.techyourchance.dagger2course.common.dependencyinjection.ActivityModule
import com.techyourchance.dagger2course.common.dependencyinjection.DaggerActivityComponent
import com.techyourchance.dagger2course.common.dependencyinjection.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.Injector
import com.techyourchance.dagger2course.common.dependencyinjection.PresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.PresentationModule

abstract class BaseActivity: AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this, appComponent))
            .build()
    }

    private val presentationComponent: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }

    protected val injector get() = Injector(presentationComponent)
}