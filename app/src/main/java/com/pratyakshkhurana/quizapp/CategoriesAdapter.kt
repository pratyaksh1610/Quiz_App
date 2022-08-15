package com.pratyakshkhurana.quizapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.each_category_view.view.*

class CategoriesAdapter(
    private val data: ArrayList<CategoryView>,
    private val listener: OnClicked
) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.each_category_view, parent, false)
        val viewHolder = CategoriesViewHolder(view)
        view.setOnClickListener {
            listener.categoryClicked(data[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val curr = data[position]
        holder.categoryText.text = curr.category
        holder.card.background = curr.cardImage
        Glide.with(holder.itemView.context).load(curr.icon).into(holder.image)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryText: TextView = view.categoryText
        val image: ImageView = view.image
        val card:CardView = view.cardView
    }

}

interface OnClicked {
    fun categoryClicked(s: CategoryView)
}