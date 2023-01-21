package com.sultan.noteapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sultan.noteapp.data.Note
import com.sultan.noteapp.databinding.NotesItemBinding

class NotesAdapter : RecyclerView.Adapter<NotesViewHolder>() {


    private val diffCallBack = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.noteId == newItem.noteId
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            NotesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = differ.currentList[position]
        holder.bind(note)

        holder.itemView.setOnClickListener {
            onClick?.invoke(note)
        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick: ((Note) -> Unit)? = null

}