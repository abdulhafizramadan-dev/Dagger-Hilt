package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyinjection.ActivityCompositionRoot
import com.techyourchance.dagger2course.common.dependencyinjection.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.Injector
import com.techyourchance.dagger2course.common.dependencyinjection.PresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.PresentationModule

abstract class BaseActivity: AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).compositionRoot

    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }

    private val component: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityCompositionRoot))
            .build()
    }

    protected val injector get() = Injector(component)
}