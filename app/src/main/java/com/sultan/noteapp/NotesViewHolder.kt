package com.sultan.noteapp

import androidx.recyclerview.widget.RecyclerView
import com.sultan.noteapp.data.Note
import com.sultan.noteapp.databinding.NotesItemBinding

class NotesViewHolder(private val binding: NotesItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(note: Note) {
        binding.tvNoteTitle.text = note.noteTitle
    }
}