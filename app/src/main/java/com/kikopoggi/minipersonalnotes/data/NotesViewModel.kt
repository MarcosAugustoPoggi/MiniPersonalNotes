package com.kikopoggi.minipersonalnotes.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

    private val notesDao = NotesDatabase.getDatabase(application).notesDao()
    private val repository: NotesRepository

    val getAllData: LiveData<List<NotesData>>

    init {
        repository = NotesRepository(notesDao)
        getAllData = repository.getAllData
    }

    fun insertData(notesData: NotesData){
        viewModelScope.launch (Dispatchers.IO) {
            repository.insertData(notesData)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}