package com.sb.park.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sb.park.model.RuneModel

@Dao
interface RuneDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRune(runeList: RuneModel)

    @Query("SELECT * FROM RuneModel")
    suspend fun getRuneList(): RuneModel?

    @Query("DELETE FROM RuneModel")
    suspend fun deleteRune()
}