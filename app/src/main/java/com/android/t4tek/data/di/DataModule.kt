package com.android.t4tek.data.di

import android.content.Context
import com.android.t4tek.data.api.ApiHelper
import com.android.t4tek.data.api.ApiHelperImpl
import com.android.t4tek.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(
            context = appContext
        )
    }
    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

}