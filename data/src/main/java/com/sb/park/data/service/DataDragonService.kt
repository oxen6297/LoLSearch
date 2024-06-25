package com.sb.park.data.service

import com.sb.park.data.model.datadragon.DataDragonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DataDragonService {

    @GET("api/versions.json")
    fun getVersion(): List<String>

    @GET("cdn/{lol_version}/data/ko_KR/champion.json")
    fun <T> getChampion(@Path("lol_version") version: String): DataDragonResponse<T>
}