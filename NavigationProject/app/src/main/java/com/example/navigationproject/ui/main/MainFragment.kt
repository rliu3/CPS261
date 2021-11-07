package com.example.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationproject.R
import androidx.navigation.Navigation

import com.example.navigationproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


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

        binding.button.setOnClickListener {
           val action: MainFragmentDirections.ActionMainFragmentToSecondFragment  =
                MainFragmentDirections.actionMainFragmentToSecondFragment(R.drawable.android_image_1)
            action.setTitle("Image 1")
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment  =
                MainFragmentDirections.actionMainFragmentToSecondFragment(R.drawable.android_image_2)
            action.setTitle("Image 2")
            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment  =
                MainFragmentDirections.actionMainFragmentToSecondFragment(R.drawable.android_image_3)
            action.setTitle("Image 3")
            Navigation.findNavController(it).navigate(action)
        }
    }

}