package com.techyourchance.dagger2course.screens.common.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.presentation.PresentationComponent
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

abstract class BaseFragment: Fragment() {
    private val presentationComponent: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .activityComponent((requireActivity() as BaseActivity).activityComponent)
            .build()
    }

    protected val injector get() = presentationComponent
}