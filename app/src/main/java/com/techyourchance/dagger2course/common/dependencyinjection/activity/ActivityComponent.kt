package com.techyourchance.dagger2course.common.dependencyinjection.activity

import com.techyourchance.dagger2course.common.dependencyinjection.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(): PresentationComponent
}