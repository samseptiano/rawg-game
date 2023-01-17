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
import com.example.rawg.databinding.FragmentGameListBinding
import com.example.rawg.ui.adapter.GameAdapter
import com.example.rawg.ui.viewmodel.GameListViewModel
import com.example.rawg.utils.obtainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class GameListFragment : BaseFragment<FragmentGameListBinding>() {
    private lateinit var endlessScroll: EndlessRecyclerViewScrollListener

    private var gameAdapter = GameAdapter()

    override val inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentGameListBinding
        get() = FragmentGameListBinding::inflate

    private val viewModel: GameListViewModel by lazy {
        obtainViewModel(requireActivity(), GameListViewModel::class.java, viewModelFactory)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()

        lifecycleScope.launchWhenCreated {
            launch {
                viewModel.getListGame(1)
            }
            launch {
                viewModel.gameList.observe(viewLifecycleOwner){
                    gameAdapter.updateGameData(it)
                }
            }
        }
    }

    private fun setupRecycleView() {
        val layoutManagers = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvList.apply {
            layoutManager = layoutManagers
            adapter = gameAdapter

        }

        endlessScroll = object : EndlessRecyclerViewScrollListener(layoutManagers) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                lifecycleScope.launch(Dispatchers.Main) {
                    viewModel.getListGame(page + 1)
                }
            }
        }

        binding.rvList.apply {
            addOnScrollListener(endlessScroll)
        }
    }

}