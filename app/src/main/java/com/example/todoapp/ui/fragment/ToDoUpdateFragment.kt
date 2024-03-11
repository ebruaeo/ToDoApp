package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentToDoUpdateBinding
import com.example.todoapp.databinding.ToDosDesigningBinding
import com.example.todoapp.ui.viewmodel.NewToDoViewModel
import com.example.todoapp.ui.viewmodel.ToDoUpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoUpdateFragment : Fragment() {

    private lateinit var binding: FragmentToDoUpdateBinding
    private lateinit var viewModel: ToDoUpdateViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToDoUpdateBinding.inflate(inflater, container, false)

        val bundle: ToDoUpdateFragmentArgs by navArgs()
        val newTask=bundle.task

        binding.editTextUpdateTime.setText(newTask.task_time)
        binding.editTextUpdateTask.setText(newTask.task_name)



        binding.buttonUpdate.setOnClickListener {
            val task_time = binding.editTextUpdateTime.text.toString()
            val task_name = binding.editTextUpdateTask.text.toString()
            viewModel.guncelle(newTask.task_id,task_time, task_name)
        }


        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ToDoUpdateViewModel by viewModels()
        viewModel = tempViewModel
    }

}