package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.ToDoDataClass

@Dao
interface ToDosDao {

    @Query("SELECT * FROM todos")
    suspend fun taskYukle() : List<ToDoDataClass>

    @Insert
    suspend fun kaydet(task: ToDoDataClass)

    @Update
    suspend fun guncelle(task: ToDoDataClass)

    @Delete
    suspend fun sil(task: ToDoDataClass)

    @Query("SELECT * FROM todos WHERE task_name like '%'||:aramaKelimesi|| '%'")
    suspend fun ara(aramaKelimesi: String) : List<ToDoDataClass>
}