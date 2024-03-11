package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentNewToDoBinding
import com.example.todoapp.ui.viewmodel.NewToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewToDoFragment : Fragment() {
    private lateinit var binding: FragmentNewToDoBinding
    private lateinit var viewModel: NewToDoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewToDoBinding.inflate(inflater, container, false)

        binding.buttonSave.setOnClickListener {
            val task_time = binding.editTextNewTime.text.toString()
            val task_name = binding.editTextNewTask.text.toString()
            viewModel.kaydet(task_time, task_name)
        }
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NewToDoViewModel by viewModels()
        viewModel = tempViewModel
    }

}