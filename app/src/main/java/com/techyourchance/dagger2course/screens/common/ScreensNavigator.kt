package com.techyourchance.dagger2course.screens.common

interface ScreensNavigator {
    fun navigateBack()
    fun navigateToQuestionDetails(questionId: String)
    fun toViewModel()
}