package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers

class FetchQuestionsUseCase(private val stackoverflowApi: StackoverflowApi) {

    sealed class Result {
        data class Success(val questions: List<Question>) : Result()
        object Failure : Result()
    }

    suspend fun fetchLatestQuestions(): Result {
        return with(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.lastActiveQuestions(20)
                if (response.isSuccessful && response.body() != null) {
                    return@with Result.Success(response.body()!!.questions)
                } else {
                    return@with Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@with Result.Failure
                } else {
                    throw t
                }
            }
        }
    }
}