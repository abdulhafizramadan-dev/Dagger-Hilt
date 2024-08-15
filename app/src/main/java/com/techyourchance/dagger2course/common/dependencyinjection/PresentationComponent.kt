package com.techyourchance.dagger2course.common.dependencyinjection

import com.techyourchance.dagger2course.questions.FetchQuestionDetailUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {

    fun screensNavigator(): ScreensNavigator

    fun dialogsNavigator(): DialogsNavigator

    fun viewMvcFactory(): ViewMvcFactory

    fun fetchQuestionsUseCase(): FetchQuestionsUseCase

    fun fetchQuestionDetails(): FetchQuestionDetailUseCase
}