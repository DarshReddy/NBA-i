package com.example.round2.assignment.data.api

import com.example.round2.assignment.data.models.PlayersResponse
import retrofit2.Response
import javax.inject.Inject

class APIHelperImpl @Inject constructor(private val apiService: APIService) : APIHelper {
    override suspend fun getPlayersData(pageNumber: Int): Response<PlayersResponse> =
        apiService.getPlayersData(pageNumber)
}