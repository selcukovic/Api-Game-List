package com.nistruct.gameapi.di

import com.nistruct.gameapi.data.remote.GameApi
import com.nistruct.gameapi.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    @Named("retrofit")
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
   fun provideGameApi(@Named("retrofit") retrofit : Retrofit) : GameApi{
       return retrofit.create(GameApi::class.java)
   }

}