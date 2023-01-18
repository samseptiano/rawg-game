package com.example.rawg.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rawg.R
import com.example.rawg.base.ui.BaseFragment
import com.example.rawg.base.ui.endlessscroll.EndlessRecyclerViewScrollListener
import com.example.rawg.data.model.GameResponse
import com.example.rawg.data.modelMapper.GameItem
import com.example.rawg.databinding.FragmentGameListBinding
import com.example.rawg.ui.adapter.GameAdapter
import com.example.rawg.ui.viewmodel.GameListViewModel
import com.example.rawg.utils.CONSTANTS
import com.example.rawg.utils.obtainViewModel
import com.example.rawg.utils.typingListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameListFragment : BaseFragment<FragmentGameListBinding>() {
    private lateinit var endlessScroll: EndlessRecyclerViewScrollListener
    private var pageSize: Int = 10
    private var currentPage:Int = 1
    private var listGame = arrayListOf<GameItem>()

    private val gameAdapter by lazy {
        GameAdapter()
    }

    override val inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentGameListBinding
        get() = FragmentGameListBinding::inflate

    private val viewModel: GameListViewModel by lazy {
        obtainViewModel(requireActivity(), GameListViewModel::class.java, viewModelFactory)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        setupClickListener()
        setupObserver()
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            launch {
                viewModel.getListGame(currentPage, pageSize)
            }
            launch {
                viewModel.gameList.observe(viewLifecycleOwner) {
                    listGame.addAll(it as List<GameItem>)

                    if(currentPage == 1){
                        gameAdapter.clearList()
                    }
                    gameAdapter.updateGameData(listGame)
                }
            }
        }
    }

    private fun setupRecycleView() {
        val layoutManagers =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        endlessScroll = object : EndlessRecyclerViewScrollListener(layoutManagers) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                lifecycleScope.launch(Dispatchers.Main) {
                    currentPage = page
                    Log.d("halaman", currentPage.toString())
                    viewModel.getListGame(currentPage + 1, pageSize)
                }
            }
        }

        binding.rvList.apply {
            layoutManager = layoutManagers
            adapter = gameAdapter
            addOnScrollListener(endlessScroll)
        }
    }

    private fun setupClickListener() {
        binding.rtSearch.typingListener {
            lifecycleScope.launch(Dispatchers.Main) {
                viewModel.getListGame(search = it.toString())
            }
        }

        gameAdapter.whenItemClick {
            navigateToDetailPage(it)
        }
    }

    private fun navigateToDetailPage(data: GameItem) {
        val bundle = bundleOf(CONSTANTS.TAG_GAME_ID to data.id)
        findNavController().navigate(R.id.gameDetailFragment, bundle)
    }

}