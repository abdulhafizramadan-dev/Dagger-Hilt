package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers

class FetchQuestionDetailUseCase(private val stackoverflowApi: StackoverflowApi) {

    sealed class Result {
        data class Success(val question: QuestionWithBody) : Result()
        object Failure : Result()
    }

    suspend fun fetchQuestionDetail(questionId: String): Result {
        return with(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    return@with Result.Success(response.body()!!.question)
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