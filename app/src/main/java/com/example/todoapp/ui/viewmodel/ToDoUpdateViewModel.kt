package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoUpdateViewModel @Inject constructor(var tdRepo: ToDoRepository) : ViewModel() {


    fun guncelle(task_id:Int,task_time: String, task_name: String) {
        CoroutineScope(Dispatchers.Main).launch {
            tdRepo.guncelle(task_id, task_time, task_name)
        }
    }
}