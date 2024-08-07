package com.sb.park.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sb.park.model.ChampionInfoModel
import com.sb.park.model.ChampionModel
import com.sb.park.model.ItemModel
import com.sb.park.model.RuneModel

@Database(
    entities = [ChampionModel::class, ChampionInfoModel::class, ItemModel::class, RuneModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        ImageTypeConverter::class,
        StatsTypeConverter::class,
        StringListTypeConverter::class,
        SkinTypeConverter::class,
        SpellTypeConverter::class,
        PassiveTypeConverter::class,
        GoldTypeConverter::class,
        RuneSlotTypeConverter::class,
        RuneTypeConverter::class
    ]
)
abstract class LOLDataBase : RoomDatabase() {
    abstract fun championDao(): ChampionDao
    abstract fun championInfoDao(): ChampionInfoDao
    abstract fun ItemDao(): ItemDao
    abstract fun RuneDao(): RuneDao
}