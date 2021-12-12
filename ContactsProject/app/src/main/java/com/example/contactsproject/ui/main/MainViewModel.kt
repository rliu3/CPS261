package com.example.contactsproject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contactsproject.Contact
import com.example.contactsproject.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacs: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    init {
        allContacs = repository.allContacts
        searchResults = repository.searchResults
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }

    fun sortDESC(){
        repository.sortDESC()
    }

    fun sortASC(){
        repository.sortASC()
    }

    fun deleteContact(id: Int) {
        repository.deleteContact(id)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacs
    }
}
