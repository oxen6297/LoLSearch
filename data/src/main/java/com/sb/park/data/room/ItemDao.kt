package com.sb.park.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sb.park.model.ItemModel

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(itemList: List<ItemModel>)

    @Query("SELECT * FROM ItemModel")
    suspend fun getItemList(): List<ItemModel>

    @Query("SELECT * FROM ItemModel WHERE name = :name")
    suspend fun getItem(name: String): ItemModel

    @Query("DELETE FROM ItemModel")
    suspend fun deleteItemList()
}