//package com.android.t4tek.app.di
//
//import android.content.Context
//import androidx.room.RoomDatabase
//import com.android.t4tek.app.MainApplication
//import com.android.t4tek.data.local.AppDatabase
//import com.android.t4tek.data.repository.UserRepositoryImpl
//import com.android.t4tek.domain.repository.UserRepository
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//class AppModule {
//    @Provides
//    @Singleton
//    fun provideApplicationContext(app: MainApplication): Context {
//        return app.applicationContext
//    }
//
//    @Provides
//    @Singleton
//    fun provideAppDatabase(context: Context): AppDatabase {
//        return AppDatabase.getDatabase(context)
//    }
//
//    @Provides
//    @Singleton
//    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository =
//        userRepositoryImpl
//}