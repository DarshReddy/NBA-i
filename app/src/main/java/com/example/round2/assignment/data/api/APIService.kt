package com.example.round2.assignment.data.api

import com.example.round2.assignment.data.models.PlayersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("api/v1/players")
    suspend fun getPlayersData(@Query("page") pageNumber: Int): Response<PlayersResponse>

}