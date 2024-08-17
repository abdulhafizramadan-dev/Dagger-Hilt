package com.techyourchance.dagger2course.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.dependencyinjection.activity.ActivityScope
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

@ActivityScope
class ScreensNavigator @Inject constructor(private val activity: AppCompatActivity) {

    fun navigateBack() {
        activity.finish()
    }

    fun navigateToQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }
}