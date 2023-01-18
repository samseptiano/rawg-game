package com.example.rawg.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rawg.base.ui.BaseAdapter
import com.example.rawg.data.model.GameResponse
import com.example.rawg.databinding.ItemGameBinding

class GameAdapter : BaseAdapter<ItemGameBinding, ItemGameViewHolder>() {
    private var listGame = arrayListOf<GameResponse>()
    private var onItemClick : (GameResponse) -> Unit = {}

    internal fun updateGameData(data: List<GameResponse?>?) {
        listGame.clear()
        data?.mapIndexed { index, gameResponse ->
            gameResponse?.let { listGame.add(it) }
            notifyItemChanged(index)
        }
    }

    internal fun whenItemClick(itemClick: (GameResponse) -> Unit) {
        onItemClick = { itemClick(it) }
    }

    override fun getBindingAdapter(parent: ViewGroup): ItemGameBinding {
        return ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun getViewHolder(adapterBinding: ItemGameBinding): ItemGameViewHolder {
        return ItemGameViewHolder(adapterBinding)
    }

    override fun bindVH(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemGameViewHolder).bind(listGame[position], onItemClick)
    }

    override fun totalItem(): Int  = listGame.size
}


class ItemGameViewHolder(private val binding: ItemGameBinding): RecyclerView.ViewHolder(binding.root) {
    internal fun bind(game: GameResponse, onItemClick: (GameResponse) -> Unit) {
        binding.titleGame.text = game.name
        binding.releaseGame.text = game.released
        if(game.background_image.isNotEmpty()) {
            Glide.with(binding.root.context).load(game.background_image).into(binding.iconGame)
        }

        binding.root.setOnClickListener {
            onItemClick(game)
        }
    }
}
