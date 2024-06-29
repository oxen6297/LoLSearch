package com.sb.park.data.adapter

import com.sb.park.data.model.datadragon.DataDragonResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

class DataDragonResponseAdapter<T>(private val delegate: JsonAdapter<Map<String, T>>) :
    JsonAdapter<DataDragonResponse<T>>() {

    @FromJson
    override fun fromJson(reader: JsonReader): DataDragonResponse<T>? {
        var data: Map<String, T>? = null

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "data" -> data = delegate.fromJson(reader)
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        return if (data != null) {
            DataDragonResponse(data)
        } else {
            null
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: DataDragonResponse<T>?) {
        if (value != null) {
            writer.beginObject()
            writer.name("data")
            delegate.toJson(writer, value.data)
            writer.endObject()
        }
    }
}