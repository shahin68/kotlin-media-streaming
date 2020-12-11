package com.shahin.stream.ui.fragments.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.shahin.stream.R
import com.shahin.stream.databinding.FragmentHomeBinding
import com.shahin.stream.mediaplayer.MediaEventListener
import com.shahin.stream.models.Media
import com.shahin.stream.ui.fragments.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModel()
    lateinit var eventListener: MediaEventListener

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

        binding.playerView.player = viewModel.getExoPlayer()
        viewModel.registerMediaPlayerListener(
            eventListener
        )

        viewModel.currentMedia.observe(viewLifecycleOwner, {

        })

        viewModel.play(
            Media(
                RawResourceDataSource.buildRawResourceUri(R.raw.test) /*Uri.parse(getString(R.string.test_media_url))*/,
                "1",
                "tag"
            )
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (!::eventListener.isInitialized) {
            eventListener = playerEventListener()
        }
    }

    private fun playerEventListener(): MediaEventListener {
        return object : MediaEventListener() {
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                Toast.makeText(requireContext(), "State Changed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        if (::eventListener.isInitialized) {
            viewModel.unregisterMediaPlayerListener(eventListener)
        }
    }

}