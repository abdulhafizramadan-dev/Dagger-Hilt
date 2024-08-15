package com.techyourchance.dagger2course.common.dependencyinjection

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment

class Injector(private val compositionRoot: PresentationCompositionRoot) {
    fun inject(fragment: QuestionsListFragment) {
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }

    fun inject(activity: QuestionDetailsActivity) {
        activity.fetchQuestionDetailUseCase = compositionRoot.fetchQuestionDetails
        activity.screensNavigator = compositionRoot.screensNavigator
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }
}