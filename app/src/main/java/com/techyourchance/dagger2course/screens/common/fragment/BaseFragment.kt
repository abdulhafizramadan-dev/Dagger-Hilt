package com.techyourchance.dagger2course.screens.common.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyinjection.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.Injector
import com.techyourchance.dagger2course.common.dependencyinjection.PresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.PresentationModule
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

abstract class BaseFragment: Fragment() {
    private val component: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule((requireActivity() as BaseActivity).activityCompositionRoot))
            .build()
    }

    protected val injector get() = Injector(component)
}