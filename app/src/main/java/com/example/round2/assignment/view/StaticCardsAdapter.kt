package com.example.round2.assignment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.round2.assignment.databinding.ItemStaticCardBinding

class StaticCardsAdapter: RecyclerView.Adapter<StaticCardsAdapter.StaticCardsViewHolder>() {

    private val staticData = ArrayList<String>()

    class StaticCardsViewHolder(
        val binding: ItemStaticCardBinding
    ): RecyclerView.ViewHolder(binding.root)

    fun addData(data: List<String>) {
        if (data.isNullOrEmpty()) return
        staticData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaticCardsViewHolder =
        StaticCardsViewHolder(
            ItemStaticCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: StaticCardsViewHolder, position: Int) {
        with(holder.binding) {
            textView.text = staticData[position]
        }
    }

    override fun getItemCount(): Int = staticData.size
}