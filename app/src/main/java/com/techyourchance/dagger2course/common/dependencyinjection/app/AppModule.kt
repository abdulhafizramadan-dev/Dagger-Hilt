package com.techyourchance.dagger2course.common.dependencyinjection.app

import com.techyourchance.dagger2course.common.dependencyinjection.Retrofit1
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.networking.UrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Retrofit1
    @AppScope
    @Provides
    fun retrofit1(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl1())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @AppScope
    @Provides
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl2())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun urlProvider(): UrlProvider {
        return UrlProvider()
    }

    @AppScope
    @Provides
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit): StackoverflowApi {
        return retrofit.create()
    }
}