package com.sultan.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sultan.noteapp.data.db.NotesDatabase
import com.sultan.noteapp.repositories.NotesRepo
import com.sultan.noteapp.viewmodel.NotesViewModel
import com.sultan.noteapp.viewmodel.providerFactory.NotesViewModelFactory

class MainActivity : AppCompatActivity() {


    val viewModel : NotesViewModel by lazy {
        val database = NotesDatabase.getDatabaseInstance(this)
        val notesRepo = NotesRepo(database)
        val notesProviederFactory = NotesViewModelFactory(notesRepo)
        ViewModelProvider(this,notesProviederFactory)[NotesViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}