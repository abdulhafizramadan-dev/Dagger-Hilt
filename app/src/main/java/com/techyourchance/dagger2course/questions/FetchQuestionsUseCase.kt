package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchQuestionsUseCase {

    sealed class Result {
        data class Success(val questions: List<Question>) : Result()
        object Failure : Result()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val stackoverflowApi = retrofit.create(StackoverflowApi::class.java)

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