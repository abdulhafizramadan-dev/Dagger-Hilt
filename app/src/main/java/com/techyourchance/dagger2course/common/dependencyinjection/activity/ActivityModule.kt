package com.techyourchance.dagger2course.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.dependencyinjection.app.AppComponent
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity,
    private val appComponent: AppComponent
) {

    @Provides
    fun activity() = activity

    @Provides
    fun application() = appComponent.application()

    @ActivityScope
    @Provides
    fun screensNavigator(activity: AppCompatActivity) = ScreensNavigator(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun stackoverflowApi() = appComponent.stackoverflowApi()
}