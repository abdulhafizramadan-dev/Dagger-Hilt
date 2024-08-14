package com.techyourchance.dagger2course.screens.common.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.composition.ActivityCompositionRoot
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

abstract class BaseFragment: Fragment() {
    val compositionRoot: ActivityCompositionRoot get() = (requireActivity() as BaseActivity).compositionRoot
}