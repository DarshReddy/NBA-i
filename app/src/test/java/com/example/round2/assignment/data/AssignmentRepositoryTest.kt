package com.example.round2.assignment.data

import com.example.round2.assignment.data.api.APIService
import com.example.round2.assignment.data.model.getDummyPlayersResponse
import com.example.round2.assignment.data.models.PlayersResponse
import com.example.round2.assignment.data.repository.AssignmentRepository
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import retrofit2.Response

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class AssignmentRepositoryTest {

    private val apiService: APIService = mock()
    private val assignmentRepository = AssignmentRepository(apiService)
    private val playersDataSuccessResponse = Response.success(getDummyPlayersResponse())
    private val playersDataErrorResponse = Response.error<PlayersResponse>(
        500,
        ResponseBody.create(null, "error")
    )

    @Test
    fun testGetPlayers_getPlayersDataShouldBeCalled_Success() {
        val page = 2

        runBlocking {
            whenever(
                apiService.getPlayersData(any())
            ).doReturn(playersDataSuccessResponse)

            val response = assignmentRepository.getPlayersData(page)

            verify(apiService).getPlayersData(page)
            verifyNoMoreInteractions(apiService)
            assertThat(response).isEqualTo(playersDataSuccessResponse)
        }
    }

    @Test
    fun testPlayers_getPlayersDataShouldBeCalled_Error() {
        val page = 2

        runBlocking {
            whenever(
                apiService.getPlayersData(any())
            ).doReturn(playersDataSuccessResponse)

            val response = assignmentRepository.getPlayersData(page)

            verify(apiService).getPlayersData(page)
            verifyNoMoreInteractions(apiService)
            assertThat(response).isEqualTo(playersDataSuccessResponse)
        }
    }
}