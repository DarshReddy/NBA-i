package com.example.round2.assignment.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.round2.assignment.data.repository.AssignmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val assignmentRepository: AssignmentRepository
) : ViewModel() {

    private val _staticData = MutableLiveData<List<String>>()
    val staticData: LiveData<List<String>> = _staticData

    fun getStaticData() {
        _staticData.value = assignmentRepository.getStaticData()
    }
}