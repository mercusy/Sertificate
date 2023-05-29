package com.example.sertificate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.sertificate.R
import com.example.sertificate.dto.GetPost
import com.example.sertificate.dto.Post
import com.squareup.picasso.Picasso

class CardAdapter(private val items: List<Post>): Adapter<CardAdapter.CardHolder>() {
    inner class CardHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return CardHolder(view)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val item = items[position]
        val author: TextView = holder.itemView.findViewById(R.id.Title)
        val icon: ImageView = holder.itemView.findViewById(R.id.icon)
        val content: TextView = holder.itemView.findViewById(R.id.content)
        val likes: TextView = holder.itemView.findViewById(R.id.likes)
        val comments: TextView = holder.itemView.findViewById(R.id.comments)
        val shares: TextView = holder.itemView.findViewById(R.id.shares)
        likes.text = item.likes.toString()
        shares.text = item.shares.toString()
        comments.text = item.comments.toString()
        author.text = item.author.name
        Picasso.get()
            .load(item.author.avatar)
            .into(icon)
        content.text = item.content

    }

    override fun getItemCount(): Int {
        return items.size
    }
}