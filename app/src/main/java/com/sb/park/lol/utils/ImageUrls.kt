package com.sb.park.lol.utils

import com.sb.park.lol.BuildConfig

internal fun championImage(id: String): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/img/champion/splash/${id}_0.jpg"

internal fun passiveImage(version: String, id: String):String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/${version}/img/passive/${id}_Passive.png"

internal fun spellImage(version: String, name: String): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/${version}/img/spell/${name}.png"

internal fun skinImage(id: String, num: Int): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/img/champion/loading/${id}_${num}.jpg"