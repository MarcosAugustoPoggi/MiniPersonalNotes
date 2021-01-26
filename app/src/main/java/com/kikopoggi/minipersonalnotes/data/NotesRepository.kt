package com.kikopoggi.minipersonalnotes.data

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao: NotesDao) {

    val getAllData: LiveData<List<NotesData>> = notesDao.getAllData()

    suspend fun insertData(notesData: NotesData){
        notesDao.insertData(notesData)
    }

    suspend fun deleteAll(){
        notesDao.deleteAll()

    }
}