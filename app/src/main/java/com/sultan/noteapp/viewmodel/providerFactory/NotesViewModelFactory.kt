package com.sultan.noteapp.viewmodel.providerFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sultan.noteapp.repositories.NotesRepo
import com.sultan.noteapp.viewmodel.NotesViewModel

class NotesViewModelFactory(
    private val notesRepo: NotesRepo
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(notesRepo) as T
    }
}