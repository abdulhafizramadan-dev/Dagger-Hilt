package com.techyourchance.dagger2course.screens.common.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

abstract class SaveStateViewModel: ViewModel() {
    abstract fun init(savedStateHandle: SavedStateHandle)
}