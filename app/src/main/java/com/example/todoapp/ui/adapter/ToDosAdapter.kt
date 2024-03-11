package com.example.todoapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.ToDoDataClass
import com.example.todoapp.databinding.FragmentHomePageBinding
import com.example.todoapp.databinding.ToDosDesigningBinding
import com.example.todoapp.ui.fragment.HomePageFragmentDirections
import com.example.todoapp.ui.viewmodel.HomePageViewModel
import com.example.todoapp.utils.gecis
import com.google.android.material.snackbar.Snackbar

class ToDosAdapter(var toDoList: List<ToDoDataClass>, var viewModel: HomePageViewModel) :
    RecyclerView.Adapter<ToDosAdapter.designingHolder>() {
    inner class designingHolder(var design: ToDosDesigningBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): designingHolder {
        val binding =
            ToDosDesigningBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return designingHolder(binding)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: designingHolder, position: Int) {
        val toDo = toDoList.get(position)
        val t = holder.design
        t.textSaat.text = toDo.task_time
        t.checkBoxToDo.text = toDo.task_name

        t.imageButtonEdit.setOnClickListener {
            val gecis = HomePageFragmentDirections.actionHomePageFragmentToToDoUpdateFragment(task = toDo)
            Navigation.gecis(it, gecis)
        }

        t.imageButtonClear.setOnClickListener {
            Snackbar.make(it, " ${toDo.task_name} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    viewModel.sil(toDo.task_id)
                }.show()
        }
    }


}