package com.example.rawg.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rawg.base.ui.BaseFragment
import com.example.rawg.base.ui.endlessscroll.EndlessRecyclerViewScrollListener
import com.example.rawg.databinding.FragmentGameDetailBinding
import com.example.rawg.databinding.FragmentGameListBinding
import com.example.rawg.ui.adapter.GameAdapter
import com.example.rawg.ui.viewmodel.GameListViewModel
import com.example.rawg.utils.CONSTANTS
import com.example.rawg.utils.obtainViewModel
import com.example.rawg.utils.typingListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetailFragment : BaseFragment<FragmentGameDetailBinding>() {
    private val gameId by lazy {
        arguments?.getInt(CONSTANTS.TAG_GAME_ID, 0)
    }

    override val inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentGameDetailBinding
        get() = FragmentGameDetailBinding::inflate

    private val viewModel: GameListViewModel by lazy {
        obtainViewModel(requireActivity(), GameListViewModel::class.java, viewModelFactory)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}