package com.sb.park.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sb.park.model.ChampionInfoModel
import com.sb.park.model.ChampionModel

@Database(
    entities = [ChampionModel::class, ChampionInfoModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [ImageTypeConverter::class, StatsTypeConverter::class, StringListTypeConverter::class, SkinTypeConverter::class, SpellTypeConverter::class, PassiveTypeConverter::class])
abstract class LOLDataBase : RoomDatabase() {
    abstract fun championDao(): ChampionDao
    abstract fun championInfoDao(): ChampionInfoDao
}