package com.techyourchance.dagger2course.common.dependencyinjection.presentation

import androidx.lifecycle.ViewModel
import com.techyourchance.dagger2course.common.dependencyinjection.ViewModelKey
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @IntoMap
    @ViewModelKey(MyViewModel::class)
    @Binds
    abstract fun myViewModel(myViewModel: MyViewModel): ViewModel

    @IntoMap
    @ViewModelKey(MyViewModel2::class)
    @Binds
    abstract fun myViewModel2(myViewModel2: MyViewModel2): ViewModel
}