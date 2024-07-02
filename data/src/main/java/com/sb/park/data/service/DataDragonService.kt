package com.sb.park.data.service

import com.sb.park.data.model.datadragon.ChampionInfoResponse
import com.sb.park.data.model.datadragon.ChampionResponse
import com.sb.park.data.model.datadragon.DataDragonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DataDragonService {

    @GET("api/versions.json")
    suspend fun getVersion(): List<String>

    @GET("cdn/{lol_version}/data/ko_KR/champion.json")
    suspend fun getChampion(@Path("lol_version") version: String): DataDragonResponse<ChampionResponse>

    @GET("cdn/{lol_version}/data/ko_KR/champion/{champion_name}.json")
    suspend fun getChampionInfo(
        @Path("lol_version") version: String,
        @Path("champion_name") name: String
    ): DataDragonResponse<ChampionInfoResponse>
}