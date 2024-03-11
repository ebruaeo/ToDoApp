package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.ToDoDataClass
import com.example.todoapp.databinding.FragmentHomePageBinding
import com.example.todoapp.ui.adapter.ToDosAdapter
import com.example.todoapp.ui.viewmodel.HomePageViewModel
import com.example.todoapp.ui.viewmodel.NewToDoViewModel
import com.example.todoapp.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel: HomePageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        viewModel.toDoListesi.observe(viewLifecycleOwner) {
            val toDosAdapter = ToDosAdapter(it, viewModel)
            binding.recyclerViewToDo.adapter = toDosAdapter
        }


        binding.recyclerViewToDo.layoutManager =
            LinearLayoutManager(binding.recyclerViewToDo.context)


        binding.addButton.setOnClickListener {
       Navigation.gecis(it, R.id.action_homePageFragment_to_newToDoFragment)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })

        return binding.root


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.toDoListYukle()
    }

}


