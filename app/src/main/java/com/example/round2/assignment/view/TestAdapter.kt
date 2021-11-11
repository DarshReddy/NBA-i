package com.example.round2.assignment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.round2.assignment.data.models.Data
import com.example.round2.assignment.databinding.ItemStaticCardBinding

class TestAdapter: RecyclerView.Adapter<TestAdapter.StaticCardsViewHolder>() {

    private val staticData = ArrayList<Data>()

    class StaticCardsViewHolder(
        val binding: ItemStaticCardBinding
    ): RecyclerView.ViewHolder(binding.root)

    fun addData(data: List<Data>) {
        if (data.isNullOrEmpty()) return
        staticData.addAll(data)
        notifyDataSetChanged()
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
            textView.text = staticData[position].getFullName()
        }
    }

    override fun getItemCount(): Int = staticData.size
}