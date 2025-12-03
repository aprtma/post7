package com.adityap.post7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.adityap.post7.databinding.ItemBookBinding

class BookAdapter (
    private var list: List<Book>,
    private val onClick: (Book) -> Unit
): RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBookBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {

            binding.txtTitle.text = book.title ?: "No Title"
            binding.txtRelease.text = book.releaseDate ?: "Unknown Release Date"

            Glide.with(binding.root.context)
                .load(book.cover)
                .into(binding.imgBook)

            binding.root.setOnClickListener {
                onClick(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}