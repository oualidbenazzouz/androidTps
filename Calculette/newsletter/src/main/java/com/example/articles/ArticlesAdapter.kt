package com.example.articles

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.article_row.view.*
import com.squareup.picasso.Picasso

class ArticlesAdapter(private val articles: List<Article>) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = articles.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article= articles[position]

        d("title","onResponse: ${article.title}")
        holder.title.text= article.title
        holder.description.text= article.description
        val imageUrl = article.urlToImage

        //Loading image using Picasso
        Picasso.get().load(imageUrl).into(holder.image)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.article_title
        val description: TextView = itemView.article_description
        var image: ImageView = itemView.article_image
    }
}



