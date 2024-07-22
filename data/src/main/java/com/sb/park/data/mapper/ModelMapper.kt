package com.sb.park.data.mapper

internal interface ModelMapper<Response, Model> {

    fun asModel(response: Response): Model
}

internal fun String.deleteHtmlTag(): String = this.replace("<.*?>".toRegex(), "")