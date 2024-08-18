package com.techyourchance.dagger2course.screens.common.viewmodel

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.techyourchance.dagger2course.questions.FetchQuestionDetailUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel2
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>,
    private val fetchQuestionDetailUseCaseProvider: Provider<FetchQuestionDetailUseCase>,
    private val savedStateRegistryOwner: SavedStateRegistryOwner
): AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return when(modelClass) {
            MyViewModel::class.java ->
                MyViewModel(
                    fetchQuestionsUseCase = fetchQuestionsUseCaseProvider.get(),
                    savedStateHandle = handle
                ) as T
            MyViewModel2::class.java ->
                MyViewModel2(
                    fetchQuestionsUseCase = fetchQuestionsUseCaseProvider.get(),
                    fetchQuestionDetailUseCase = fetchQuestionDetailUseCaseProvider.get()
                ) as T
            else -> throw IllegalArgumentException("unsupported view model class: $modelClass")
        }
    }
}
