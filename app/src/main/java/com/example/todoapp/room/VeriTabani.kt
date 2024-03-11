package com.example.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.entity.ToDoDataClass

@Database(entities = [ToDoDataClass::class], version = 1)
abstract class VeriTabani : RoomDatabase() {
    abstract fun getToDosDao(): ToDosDao
}