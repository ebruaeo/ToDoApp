package com.example.todoapp.data.datasource

import android.util.Log
import com.example.todoapp.data.entity.ToDoDataClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource {

    suspend fun kaydet(task_time: String, task_name: String) {
        Log.e("Yeni task ekle", "$task_time - $task_name")
    }

    suspend fun guncelle(task_id: Int, task_time: String, task_name: String) {
        Log.e("Task Güncelle", "$task_id- $task_time - $task_name")
    }

    suspend fun sil(task_id: Int) {
        Log.e("Task Sil", task_id.toString())
    }

    suspend fun toDoListYukle(): List<ToDoDataClass> = withContext(Dispatchers.IO) {
        val tdList = listOf(
            ToDoDataClass(1, "09:00", "Wake Up!"),
            ToDoDataClass(2, "10:00", "Reading Book!"),
            ToDoDataClass(3, "12:15", "Lunch!"),
            ToDoDataClass(4, "14:30", "Exercise!"),
            ToDoDataClass(5, "15:00", "Code!"),
            ToDoDataClass(6, "17:30", "Go Shopping")
        )
        return@withContext tdList
    }

    suspend fun ara(aramaKelimesi: String): List<ToDoDataClass> =
        withContext(Dispatchers.IO) {
            val tdList = listOf(
                ToDoDataClass(1, "09:00", "Wake Up!"),
            )
            return@withContext tdList
        }
}