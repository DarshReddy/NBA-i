package com.example.round2.assignment.ui.explore

import androidx.lifecycle.ViewModel
import com.example.round2.assignment.data.repository.AssignmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val assignmentRepository: AssignmentRepository
) : ViewModel() {

    fun getStaticData(): List<String> {
        return assignmentRepository.getStaticData()
    }
}