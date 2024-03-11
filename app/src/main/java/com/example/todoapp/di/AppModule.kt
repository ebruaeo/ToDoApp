package com.example.todoapp.di

import com.example.todoapp.data.datasource.ToDoDataSource
import com.example.todoapp.data.repo.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDoRepository(tdDataSource: ToDoDataSource): ToDoRepository {
        return ToDoRepository(tdDataSource)
    }

    @Provides
    @Singleton

    fun provideToDoDataSource(): ToDoDataSource {
        return ToDoDataSource()
    }


}