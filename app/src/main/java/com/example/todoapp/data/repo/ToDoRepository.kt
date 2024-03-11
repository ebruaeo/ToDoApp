package com.example.todoapp.data.repo

import com.example.todoapp.data.datasource.ToDoDataSource
import com.example.todoapp.data.entity.ToDoDataClass

class ToDoRepository(var tdDataSource: ToDoDataSource) {
    suspend fun kaydet(task_time: String, task_name: String) = tdDataSource.kaydet(task_time,task_name)

    suspend fun guncelle(task_id:Int,task_time: String, task_name: String) = tdDataSource.guncelle(task_id, task_time, task_name)

    suspend fun sil(task_id: Int)=tdDataSource.sil(task_id)

    suspend fun toDoListYukle(): List<ToDoDataClass> = tdDataSource.toDoListYukle()

    suspend fun ara(aramaKelimesi: String) : List<ToDoDataClass> = tdDataSource.ara(aramaKelimesi)

}