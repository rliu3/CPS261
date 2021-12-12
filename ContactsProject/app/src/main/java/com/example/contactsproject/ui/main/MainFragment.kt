package com.example.contactsproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.contactsproject.R

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsproject.Contact
import androidx.fragment.app.viewModels
import com.example.contactsproject.MainActivity

import java.util.*

import com.example.contactsproject.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
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
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun listenerSetup() {

        binding.button2.setOnClickListener {
            val name = binding.editName.text.toString()
            val phone = binding.editPhone.text.toString()

            if (name != "" && phone != "") {
                val contact = Contact(name, phone)
                viewModel.insertContact(contact)
            } else {
                //toast
                Toast.makeText(requireActivity(), "You must enter a search criteria in the name field", Toast.LENGTH_LONG).show()

            }
        }
        binding.button3.setOnClickListener {
            viewModel.sortASC()
        }
        binding.button4.setOnClickListener {
            viewModel.sortDESC()
        }

        binding.button.setOnClickListener { viewModel.findContact(binding.editName.text.toString()) }

    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let  {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->

            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    Toast.makeText(requireActivity(), "No record found for that name", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener(object : ContactListAdapter.onItemClickListener{
            override fun onClick(id: String) {
                var contactId: Int = parseInt(id)
                viewModel.deleteContact(contactId)
            }
        })
    }

}