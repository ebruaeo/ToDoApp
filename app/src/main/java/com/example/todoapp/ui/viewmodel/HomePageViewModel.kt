package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.ToDoDataClass
import com.example.todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(var tdRepo: ToDoRepository) : ViewModel() {

    var toDoListesi =MutableLiveData <List<ToDoDataClass>>()

    init {
        toDoListYukle()
    }

    fun sil(task_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            tdRepo.sil(task_id)
            toDoListYukle()
        }

    }

   fun toDoListYukle() {
       CoroutineScope(Dispatchers.Main).launch {
           toDoListesi.value =tdRepo.toDoListYukle()
       }
   }

    fun ara(aramaKelimesi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoListesi.value =tdRepo.ara(aramaKelimesi)
        }
    }
}