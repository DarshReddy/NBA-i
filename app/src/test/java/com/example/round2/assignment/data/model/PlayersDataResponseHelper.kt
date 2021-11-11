package com.example.round2.assignment.data.model

import com.example.round2.assignment.data.models.Meta
import com.example.round2.assignment.data.models.PlayersResponse

fun getDummyPlayersResponse() = PlayersResponse(
    data = listOf(),
    meta = getDummyMetaData()
)

fun getDummyMetaData() = Meta(
    current_page = 3,
    next_page = 4,
    per_page = 25,
    total_count = 3789,
    total_pages = 277
)
