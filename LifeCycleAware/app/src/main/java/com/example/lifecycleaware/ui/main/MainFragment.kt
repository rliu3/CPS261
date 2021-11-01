package com.example.lifecycleaware.ui.main

import android.icu.text.SimpleDateFormat
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lifecycleaware.DemoObserver
import com.example.lifecycleaware.R
import com.example.lifecycleaware.databinding.MainFragmentBinding
import com.example.lifecycleaware.BR.myViewModel


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            binding.setVariable(myViewModel, viewModel)
            lifecycle.addObserver(DemoObserver())
            val currTime = System.currentTimeMillis()
            val d = SimpleDateFormat("HH:mm:ss.SSS")
            val time = d.format(currTime)
            viewModel.setState("onCreate was fired on $time")

        }

        override fun onResume() {
            super.onResume()
            val currTime = System.currentTimeMillis()
            val d = SimpleDateFormat("HH:mm:ss.SSS")
            val time = d.format(currTime)
            viewModel.setState("onResume was fired on $time")
            viewModel.setState("************\n")


        }

        override fun onPause() {
            super.onPause()
            val currTime = System.currentTimeMillis()
            val d = SimpleDateFormat("HH:mm:ss.SSS")
            val time = d.format(currTime)
            viewModel.setState("onPause was fired on $time")
            viewModel.setState("************\n")

        }

        override fun onStart() {
            super.onStart()
            val currTime = System.currentTimeMillis()
            val d = SimpleDateFormat("HH:mm:ss.SSS")
            val time = d.format(currTime)
            viewModel.setState("onStart was fired on $time")
        }


        override fun onStop() {
            super.onStop()
            val currTime = System.currentTimeMillis()
            val d = SimpleDateFormat("HH:mm:ss.SSS")
            val time = d.format(currTime)
            viewModel.setState("onStop was fired on $time")
        }

        override fun onDestroy() {
            super.onDestroy()
            val currTime = System.currentTimeMillis()
            val d = SimpleDateFormat("HH:mm:ss.SSS")
            val time = d.format(currTime)
            viewModel.setState("onDestroy was fired on $time")
            viewModel.setState("************\n")
        }

    }


