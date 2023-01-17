package com.example.rawg.ui.fragment.sample.sample_fragment

import android.os.Bundle
import android.view.*
import com.example.rawg.base.ui.BaseFragment
import com.example.rawg.ui.fragment.sample.ExampleViewModel
import com.example.rawg.databinding.FragmentSampleBinding
import com.example.rawg.utils.obtainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleFragment : BaseFragment<FragmentSampleBinding>() {

    override val inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSampleBinding
        get() = FragmentSampleBinding::inflate

    private val viewModel: ExampleViewModel by lazy {
        obtainViewModel(requireActivity(), ExampleViewModel::class.java, viewModelFactory)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}