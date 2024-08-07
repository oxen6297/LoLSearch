package com.sb.park.data.room

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.sb.park.model.ChampionInfoModel
import com.sb.park.model.ImageModel
import com.sb.park.model.ItemModel
import com.sb.park.model.RuneModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ImageTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): ImageModel? {
        val adapter: JsonAdapter<ImageModel> =
            moshi.adapter(ImageModel::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromImage(type: ImageModel): String {
        val adapter: JsonAdapter<ImageModel> =
            moshi.adapter(ImageModel::class.java)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class StatsTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): ChampionInfoModel.StatModel? {
        val adapter: JsonAdapter<ChampionInfoModel.StatModel> =
            moshi.adapter(ChampionInfoModel.StatModel::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromStat(type: ChampionInfoModel.StatModel): String {
        val adapter: JsonAdapter<ChampionInfoModel.StatModel> =
            moshi.adapter(ChampionInfoModel.StatModel::class.java)
        return adapter.toJson(type)
    }
}


@ProvidedTypeConverter
class StringListTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): List<String>? {
        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromList(type: List<String>): String {
        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class SkinTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): List<ChampionInfoModel.SkinModel>? {
        val listType =
            Types.newParameterizedType(List::class.java, ChampionInfoModel.SkinModel::class.java)
        val adapter: JsonAdapter<List<ChampionInfoModel.SkinModel>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromSkin(type: List<ChampionInfoModel.SkinModel>): String {
        val listType =
            Types.newParameterizedType(List::class.java, ChampionInfoModel.SkinModel::class.java)
        val adapter: JsonAdapter<List<ChampionInfoModel.SkinModel>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class SpellTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): List<ChampionInfoModel.SpellModel>? {
        val listType =
            Types.newParameterizedType(List::class.java, ChampionInfoModel.SpellModel::class.java)
        val adapter: JsonAdapter<List<ChampionInfoModel.SpellModel>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromSpell(type: List<ChampionInfoModel.SpellModel>): String {
        val listType =
            Types.newParameterizedType(List::class.java, ChampionInfoModel.SpellModel::class.java)
        val adapter: JsonAdapter<List<ChampionInfoModel.SpellModel>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class PassiveTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): ChampionInfoModel.PassiveModel? {
        val adapter: JsonAdapter<ChampionInfoModel.PassiveModel> =
            moshi.adapter(ChampionInfoModel.PassiveModel::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromPassive(type: ChampionInfoModel.PassiveModel): String {
        val adapter: JsonAdapter<ChampionInfoModel.PassiveModel> =
            moshi.adapter(ChampionInfoModel.PassiveModel::class.java)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class GoldTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): ItemModel.GoldModel? {
        val adapter: JsonAdapter<ItemModel.GoldModel> =
            moshi.adapter(ItemModel.GoldModel::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromGold(type: ItemModel.GoldModel): String {
        val adapter: JsonAdapter<ItemModel.GoldModel> =
            moshi.adapter(ItemModel.GoldModel::class.java)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class RuneSlotTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): RuneModel.RuneSlot? {
        val adapter: JsonAdapter<RuneModel.RuneSlot> =
            moshi.adapter(RuneModel.RuneSlot::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromRuneSlot(type: RuneModel.RuneSlot): String {
        val adapter: JsonAdapter<RuneModel.RuneSlot> =
            moshi.adapter(RuneModel.RuneSlot::class.java)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class RuneTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): RuneModel.Rune? {
        val adapter: JsonAdapter<RuneModel.Rune> =
            moshi.adapter(RuneModel.Rune::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromRune(type: RuneModel.Rune): String {
        val adapter: JsonAdapter<RuneModel.Rune> =
            moshi.adapter(RuneModel.Rune::class.java)
        return adapter.toJson(type)
    }
}