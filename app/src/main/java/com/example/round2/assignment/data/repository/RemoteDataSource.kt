package com.example.round2.assignment.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.round2.assignment.data.models.Data

class RemoteDataSource(
    private val assignmentRepository: AssignmentRepository
): PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = assignmentRepository.getPlayersData(currentLoadingPageKey)
            val responseData = mutableListOf<Data>()
            val data = response.body()?.data
            if (data != null) {
                responseData.addAll(data)
            }

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}