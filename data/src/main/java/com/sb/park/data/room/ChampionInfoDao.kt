package com.sb.park.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sb.park.model.ChampionInfoModel

@Dao
interface ChampionInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChampion(champion: ChampionInfoModel)

    @Query("SELECT * FROM ChampionInfoModel")
    suspend fun getChampion(): ChampionInfoModel?

    @Query("DELETE FROM ChampionInfoModel")
    suspend fun deleteChampion()
}