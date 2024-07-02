package com.sb.park.data.room

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.sb.park.model.ChampionInfoModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ImageTypeConverter @Inject constructor(private val moshi: Moshi) {

    @TypeConverter
    fun fromString(value: String): ChampionInfoModel.ImageModel? {
        val adapter: JsonAdapter<ChampionInfoModel.ImageModel> =
            moshi.adapter(ChampionInfoModel.ImageModel::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromImage(type: ChampionInfoModel.ImageModel): String {
        val adapter: JsonAdapter<ChampionInfoModel.ImageModel> =
            moshi.adapter(ChampionInfoModel.ImageModel::class.java)
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
    fun fromImage(type: List<String>): String {
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
    fun fromImage(type: List<ChampionInfoModel.SkinModel>): String {
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
    fun fromImage(type: List<ChampionInfoModel.SpellModel>): String {
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
    fun fromImage(type: ChampionInfoModel.PassiveModel): String {
        val adapter: JsonAdapter<ChampionInfoModel.PassiveModel> =
            moshi.adapter(ChampionInfoModel.PassiveModel::class.java)
        return adapter.toJson(type)
    }
}