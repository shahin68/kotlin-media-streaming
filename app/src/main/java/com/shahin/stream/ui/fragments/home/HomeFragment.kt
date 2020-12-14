package com.shahin.stream.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.shahin.stream.R
import com.shahin.stream.databinding.FragmentHomeBinding
import com.shahin.stream.data.models.Media
import com.shahin.stream.ui.fragments.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playerView.player = viewModel.mediaPlayer



    }

    private fun playMedia() {
        viewModel.play(
            Media(
                RawResourceDataSource.buildRawResourceUri(R.raw.test) /*Uri.parse(getString(R.string.test_media_url))*/,
                "1",
                "tag"
            )
        )
    }
}