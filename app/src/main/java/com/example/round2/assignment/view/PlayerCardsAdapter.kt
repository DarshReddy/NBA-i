package com.example.round2.assignment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.round2.assignment.BR
import com.example.round2.assignment.R
import com.example.round2.assignment.data.models.Data
import com.example.round2.assignment.databinding.ItemPlayerCardBinding

class PlayerCardsAdapter(
    private val onCardClicked: (player: Data) -> Unit
): PagingDataAdapter<Data, PlayerCardsAdapter.PlayerCardsViewHolder>(DataDifferentiator) {

    private val randomImgUrl = "https://source.unsplash.com/random/200x200?sig="

    class PlayerCardsViewHolder(
        val binding: ItemPlayerCardBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerCardsViewHolder =
        PlayerCardsViewHolder(
            ItemPlayerCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PlayerCardsViewHolder, position: Int) {
        with(holder.binding) {
            val playerData = getItem(position)
            setVariable(BR.player, playerData)
            if (playerData != null) {
                playerData.imageUrl = randomImgUrl+position
                playerImage.load(playerData.imageUrl) {
                    placeholder(R.drawable.ic_baseline_account_box_24)
                }
                root.setOnClickListener {
                    onCardClicked(playerData)
                }
            }
        }
    }

    object DataDifferentiator : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}