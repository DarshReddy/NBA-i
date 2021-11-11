package com.example.round2.assignment.view

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.ImageRequest
import com.example.round2.assignment.BR
import com.example.round2.assignment.R
import com.example.round2.assignment.data.models.Data
import com.example.round2.assignment.databinding.ItemPlayerCardBinding

class PlayerCardsAdapter(
    private val onCardClicked: (player: Data) -> Unit
): PagingDataAdapter<Data, PlayerCardsAdapter.PlayerCardsViewHolder>(DataDifferentiator) {

    private val playerImageUrl = "https://nba-players.herokuapp.com/players/"

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
                playerData.imageUrl = playerImageUrl+"${playerData.last_name}/${playerData.first_name}"
                playerImage.load(playerData.imageUrl) {
                    listener(
                        onError = { _: ImageRequest, _: Throwable ->
                            playerImage.load(R.drawable.ic_baseline_account_box_24) }
                    )
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