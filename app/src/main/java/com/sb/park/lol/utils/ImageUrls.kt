package com.sb.park.lol.utils

import com.sb.park.lol.BuildConfig

internal fun splashImage(id: String): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/img/champion/splash/${id}_0.jpg"

internal fun spellImage(version: String, name: String): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/${version}/img/spell/${name}.png"

internal fun skinImage(id: String, num: Int): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/img/champion/loading/${id}_${num}.jpg"