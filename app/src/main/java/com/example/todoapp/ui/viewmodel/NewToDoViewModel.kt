package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewToDoViewModel @Inject constructor(var tdRepo: ToDoRepository) : ViewModel() {


    fun kaydet(task_time: String, task_name: String) {
        CoroutineScope(Dispatchers.Main).launch {
            tdRepo.kaydet(task_time, task_name)
        }
    }

}