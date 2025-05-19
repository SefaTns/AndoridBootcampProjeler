package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.WorksDataSource
import com.example.todoapp.data.repo.WorksRepository
import com.example.todoapp.room.DataBase
import com.example.todoapp.room.WorksDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton

    fun provideWorksRepository(worksDataSource: WorksDataSource) : WorksRepository {
        return WorksRepository(worksDataSource)
    }

    @Provides
    @Singleton
    fun provideWorksDataSource(worksDao: WorksDao) : WorksDataSource {
        return WorksDataSource(worksDao)
    }

    @Provides
    @Singleton
    fun provideWorksDao(@ApplicationContext context: Context) : WorksDao {
        val dataBase = Room.databaseBuilder(context, DataBase::class.java, "toDoApp.sqlite")
            .createFromAsset("toDoApp.sqlite")
            .build()

        return dataBase.getWorksDao()
    }
}