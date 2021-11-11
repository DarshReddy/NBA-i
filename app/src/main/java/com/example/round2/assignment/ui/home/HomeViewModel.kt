package com.example.round2.assignment.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.round2.assignment.data.repository.AssignmentRepository
import com.example.round2.assignment.data.repository.RemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val assignmentRepository: AssignmentRepository
) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 2)) {
        RemoteDataSource(assignmentRepository)
    }.flow.cachedIn(viewModelScope)

}