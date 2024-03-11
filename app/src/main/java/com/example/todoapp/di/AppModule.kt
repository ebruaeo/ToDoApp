package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.ToDoDataSource
import com.example.todoapp.data.repo.ToDoRepository
import com.example.todoapp.room.ToDosDao
import com.example.todoapp.room.VeriTabani
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
    fun provideToDoRepository(tdDataSource: ToDoDataSource): ToDoRepository {
        return ToDoRepository(tdDataSource)
    }

    @Provides
    @Singleton

    fun provideToDoDataSource(tdDao: ToDosDao): ToDoDataSource {
        return ToDoDataSource(tdDao)
    }

    @Provides
    @Singleton
    fun provideToDosDao(@ApplicationContext context: Context): ToDosDao {
        val vt = Room.databaseBuilder(context, VeriTabani::class.java, "todo_db.sqlite")
            .createFromAsset("todo_db.sqlite").build()
        return vt.getToDosDao()
    }
}