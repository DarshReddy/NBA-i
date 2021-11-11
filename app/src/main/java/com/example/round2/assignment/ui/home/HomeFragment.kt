package com.example.round2.assignment.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.round2.assignment.R
import com.example.round2.assignment.data.models.Data
import com.example.round2.assignment.databinding.FragmentHomeBinding
import com.example.round2.assignment.ui.detail.PlayerDetailActivity
import com.example.round2.assignment.utils.addScrollDirectionListener
import com.example.round2.assignment.utils.gone
import com.example.round2.assignment.utils.visible
import com.example.round2.assignment.view.OnScrollListener
import com.example.round2.assignment.view.PlayerCardsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private lateinit var interfaceOnScrollListener: OnScrollListener
    private lateinit var playerCardsAdapter: PlayerCardsAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activity?.let {
            instantiateOnScrollListener(it)
        }

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        setupView()
    }

    private fun setupView() {
        viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.listData.collectLatest {
                playerCardsAdapter.submitData(it)
                Log.d("API FLOW", "Players added")
            }
        }
        playerCardsAdapter.addLoadStateListener {
            when (it.refresh) {
                LoadState.Loading -> {
                    binding.progressBar.visible()
                    Log.d("API FLOW", "Players loading")
                }
                is LoadState.Error -> {
                    binding.progressBar.gone()
                    binding.errorText.text = resources.getString(R.string.error_text)
                    Log.d("API FLOW", "Players error")
                }
                else -> {
                    binding.progressBar.gone()
                    binding.errorText.gone()
                    Log.d("API FLOW", "Players success")
                }
            }
        }
    }

    private fun setupList() {
        playerCardsAdapter = PlayerCardsAdapter(::onCardClicked)
        binding.homeRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = playerCardsAdapter
        }
        binding.homeRecycler.addScrollDirectionListener(interfaceOnScrollListener)
    }

    private fun onCardClicked(player: Data) {
        val intent = Intent(activity, PlayerDetailActivity::class.java)
        intent.putExtra("player", player)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun instantiateOnScrollListener(context: FragmentActivity) {
        interfaceOnScrollListener = context as OnScrollListener
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE FLOW", "Fragment paused")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE FLOW", "Fragment resumed")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE FLOW", "Fragment stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE FLOW", "Fragment destroyed")
    }
}