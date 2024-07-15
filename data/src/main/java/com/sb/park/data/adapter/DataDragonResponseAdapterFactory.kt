package com.sb.park.data.adapter

import com.sb.park.data.model.datadragon.DataDragonResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class DataDragonResponseAdapterFactory : JsonAdapter.Factory {
    override fun create(
        type: Type,
        annotations: MutableSet<out Annotation>,
        moshi: Moshi
    ): JsonAdapter<*>? {
        if (type is ParameterizedType && type.rawType == DataDragonResponse::class.java) {
            val valueType = type.actualTypeArguments[0]
            val delegate = moshi.adapter<Map<String, Any>>(
                Types.newParameterizedType(
                    Map::class.java,
                    String::class.java,
                    valueType
                )
            )
            return DataDragonResponseAdapter(delegate)
        }
        return null
    }
}