package com.techyourchance.dagger2course.common.composition

import android.app.Activity
import com.techyourchance.dagger2course.questions.FetchQuestionDetailUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator

class ActivityCompositionRoot(
    private val activity: Activity,
    private val appCompositionRoot: AppCompositionRoot
) {
    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    private val stackoverflowApi get() = appCompositionRoot.stackoverflowApi

    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)

    val fetchQuestionDetails get() = FetchQuestionDetailUseCase(stackoverflowApi)
}