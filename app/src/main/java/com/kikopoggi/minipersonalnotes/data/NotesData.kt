package com.kikopoggi.minipersonalnotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NotesData (

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String

    )
