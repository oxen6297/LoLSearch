package com.sb.park.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sb.park.model.ChampionModel

@Database(entities = [ChampionModel::class], version = 1, exportSchema = true)
abstract class LOLDataBase: RoomDatabase() {
    abstract fun championDao(): ChampionDao
    abstract fun championInfoDao(): ChampionInfoDao
}