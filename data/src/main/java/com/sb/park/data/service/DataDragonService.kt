package com.sb.park.data.service

import com.sb.park.data.model.datadragon.DataDragonModel
import retrofit2.http.GET

interface DataDragonService {

    @GET("14.12.1/data/ko_KR/champion.json")
    fun<T> getChampion(): DataDragonModel<T>
}