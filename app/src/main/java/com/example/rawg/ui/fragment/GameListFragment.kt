package com.example.rawg.ui.fragment

import EndlessRecyclerViewScrollListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rawg.base.ui.BaseFragment
import com.example.rawg.databinding.FragmentGameListBinding
import com.example.rawg.ui.adapter.GameAdapter
import com.example.rawg.ui.viewmodel.GameListViewModel
import com.example.rawg.utils.obtainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class GameListFragment : BaseFragment<FragmentGameListBinding>() {
    private var endlessScroll: EndlessRecyclerViewScrollListener? = null

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

        endlessScroll?.setOnLoadMoreListener(object : EndlessRecyclerViewScrollListener.OnLoadMoreListener {
            override fun onLoadMore(step: Int) {
                lifecycleScope.launch(Dispatchers.IO) {
                    viewModel.getListGame(step + 1)
                }
            }
        })

        binding.rvList.apply {
            layoutManager = layoutManagers
            addOnScrollListener(endlessScroll!!)
            adapter = gameAdapter
        }
    }

}