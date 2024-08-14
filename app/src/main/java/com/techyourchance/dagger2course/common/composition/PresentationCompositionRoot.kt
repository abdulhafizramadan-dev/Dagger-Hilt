package com.techyourchance.dagger2course.common.composition

import com.techyourchance.dagger2course.questions.FetchQuestionDetailUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory

class PresentationCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot) {

    private val fragmentManager get() = activityCompositionRoot.fragmentManager

    private val layoutInflater get() = activityCompositionRoot.layoutInflater

    private val stackoverflowApi get() = activityCompositionRoot.stackoverflowApi

    val screensNavigator get() = activityCompositionRoot.screensNavigator

    val dialogsNavigator get() = DialogsNavigator(fragmentManager)

    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)

    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)

    val fetchQuestionDetails get() = FetchQuestionDetailUseCase(stackoverflowApi)
}