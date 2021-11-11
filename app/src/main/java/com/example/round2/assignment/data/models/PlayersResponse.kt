package com.example.round2.assignment.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayersResponse(
    @Json(name = "data")
    val data: List<Data>?,
    @Json(name = "meta")
    val meta: Meta?
) : Parcelable

@Parcelize
data class Data(
    @Json(name = "image_url")
    var imageUrl: String? = "",
    @Json(name = "first_name")
    val first_name: String? = "",
    @Json(name = "height_feet")
    val height_feet: Int? = 0,
    @Json(name = "height_inches")
    val height_inches: Int? = 0,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "last_name")
    val last_name: String?,
    @Json(name = "position")
    val position: String?,
    @Json(name = "team")
    val team: Team?,
    @Json(name = "weight_pounds")
    val weight_pounds: Int?
): Parcelable {
    fun getFullName(): String {
        return "$first_name $last_name"
    }

    fun getHeight(): String {
        if (height_feet == null || height_inches == null) {
            return "Height data unavailable"
        }
        return "$height_feet ft $height_inches in"
    }
}

@Parcelize
data class Meta(
    @Json(name = "current_page")
    val current_page: Int?,
    @Json(name = "next_page")
    val next_page: Int?,
    @Json(name = "per_page")
    val per_page: Int?,
    @Json(name = "total_count")
    val total_count: Int?,
    @Json(name = "total_pages")
    val total_pages: Int?
) : Parcelable

@Parcelize
data class Team(
    @Json(name = "abbreviation")
    val abbreviation: String?,
    @Json(name = "city")
    val city: String?,
    @Json(name = "conference")
    val conference: String?,
    @Json(name = "division")
    val division: String?,
    @Json(name = "full_name")
    val full_name: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?
) : Parcelable