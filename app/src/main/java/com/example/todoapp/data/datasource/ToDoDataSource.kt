package com.example.todoapp.data.datasource

import android.util.Log
import com.example.todoapp.data.entity.ToDoDataClass
import com.example.todoapp.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tdDao: ToDosDao) {

    suspend fun kaydet(task_time: String, task_name: String) {
       val newTask = ToDoDataClass(0,task_time,task_name)
        tdDao.kaydet(newTask)
    }

    suspend fun guncelle(task_id: Int, task_time: String, task_name: String) {
        val updatedTask = ToDoDataClass(task_id,task_time,task_name)
        tdDao.guncelle(updatedTask)
    }

    suspend fun sil(task_id: Int) {
        val deletedTask = ToDoDataClass(task_id,"","")
        tdDao.sil(deletedTask)
    }

    suspend fun toDoListYukle(): List<ToDoDataClass> = withContext(Dispatchers.IO) {
        return@withContext tdDao.taskYukle()
    }

    suspend fun ara(aramaKelimesi: String): List<ToDoDataClass> =
        withContext(Dispatchers.IO) {
            return@withContext tdDao.ara(aramaKelimesi)
        }
}