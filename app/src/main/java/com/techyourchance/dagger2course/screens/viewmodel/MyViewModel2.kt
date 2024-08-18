package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.ViewModel
import com.techyourchance.dagger2course.questions.FetchQuestionDetailUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import javax.inject.Inject

class MyViewModel2 @Inject constructor(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase,
    private val fetchQuestionDetailUseCase: FetchQuestionDetailUseCase
): ViewModel()