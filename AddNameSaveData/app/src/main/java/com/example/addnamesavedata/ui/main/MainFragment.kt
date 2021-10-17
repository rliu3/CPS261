package com.example.addnamesavedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.addnamesavedata.R
import com.example.addnamesavedata.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.displayNames.text = viewModel.getNames()

        binding.btn1.setOnClickListener {
            if (binding.editTextName.text.isNotEmpty()){
                viewModel.setName(binding.editTextName.text.toString())
                binding.displayNames.text = viewModel.getNames()
                binding.editTextName.text.clear()
            }
            else{
                binding.displayNames.text = "Please enter a name"
            }
        }
    }

}