package com.sultan.noteapp.repositories

import com.sultan.noteapp.data.Note
import com.sultan.noteapp.data.db.NotesDatabase

class NotesRepo(
    notesDatabase: NotesDatabase
) {
    private val notesDao = notesDatabase.noteDao

    suspend fun upsertNote(note: Note) = notesDao.upsertNote(note)

    suspend fun deleteNote(note: Note) = notesDao.deleteNote(note)

    fun getNotes() = notesDao.selectNotes()

    fun searchNotes(searchQuery: String) = notesDao.searchInNotesTitle(searchQuery)

    suspend fun deleteAllNotes() = notesDao.deleteAllNote()
}