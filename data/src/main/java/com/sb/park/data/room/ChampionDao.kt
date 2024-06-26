package com.sb.park.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sb.park.model.ChampionModel

@Dao
interface ChampionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChampion(championList: List<ChampionModel>)

    @Query("SELECT * FROM ChampionModel")
    suspend fun getChampionList(): List<ChampionModel>

    @Query("DELETE FROM ChampionModel")
    suspend fun deleteChampionList()
}