package com.example.round2.assignment.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.round2.assignment.databinding.FragmentProfileBinding
import com.example.round2.assignment.utils.addScrollDirectionListener
import com.example.round2.assignment.view.OnScrollListener
import com.example.round2.assignment.view.StaticCardsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by viewModels()
    private var _binding: FragmentProfileBinding? = null
    private lateinit var interfaceOnScrollListener: OnScrollListener

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

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val profileRecycler = binding.profileRecycler
        profileRecycler.layoutManager = LinearLayoutManager(requireContext())
        profileViewModel.getStaticData()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel.staticData.observe(viewLifecycleOwner, {
            val staticAdapter = StaticCardsAdapter()
            staticAdapter.addData(it)
            binding.profileRecycler.adapter = staticAdapter
        })

        binding.profileRecycler.addScrollDirectionListener(interfaceOnScrollListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun instantiateOnScrollListener(context: FragmentActivity) {
        interfaceOnScrollListener = context as OnScrollListener
    }
}