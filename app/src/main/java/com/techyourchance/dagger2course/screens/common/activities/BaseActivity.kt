package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.composition.AppCompositionRoot

abstract class BaseActivity: AppCompatActivity() {
    val compositionRoot: AppCompositionRoot get() = (application as MyApplication).compositionRoot
}