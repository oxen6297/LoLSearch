package com.sb.park.data.mapper

interface ModelMapper<Response, Model> {

    fun asModel(response: Response): Model
}