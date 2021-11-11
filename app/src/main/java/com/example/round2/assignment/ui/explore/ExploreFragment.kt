package com.example.round2.assignment.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.round2.assignment.databinding.FragmentExploreBinding
import com.example.round2.assignment.view.OnScrollListener
import com.example.round2.assignment.view.StaticCardsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFragment : Fragment() {

    private val exploreViewModel: ExploreViewModel by viewModels()
    private var _binding: FragmentExploreBinding? = null
    private lateinit var interfaceOnScrollListener: OnScrollListener

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.let {
            instantiateOnScrollListener(it)
        }

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val exploreRecycler = binding.exploreRecycler
        exploreRecycler.layoutManager = LinearLayoutManager(requireContext())
        val adapter = StaticCardsAdapter()
        adapter.addData(exploreViewModel.getStaticData())
        exploreRecycler.adapter = adapter
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.exploreRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    interfaceOnScrollListener.setNavBarVisibility(false)
                } else if (dy < 0) {
                    interfaceOnScrollListener.setNavBarVisibility(true)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun instantiateOnScrollListener(context: FragmentActivity) {
        interfaceOnScrollListener = context as OnScrollListener
    }
}