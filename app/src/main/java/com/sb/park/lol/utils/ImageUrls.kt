package com.sb.park.lol.utils

import com.sb.park.lol.BuildConfig

internal fun championImage(id: String): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/img/champion/splash/${id}_0.jpg"

internal fun passiveImage(version: String, fileName: String): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/${version}/img/passive/${fileName}"

internal fun spellImage(version: String, fileName: String): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/${version}/img/spell/${fileName}"

internal fun skinImage(id: String, num: Int): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/img/champion/loading/${id}_${num}.jpg"

internal fun itemImage(version: String, fileName: String): String =
    "${BuildConfig.DATA_DRAGON_BASE_URL}cdn/${version}/img/profileicon/${fileName}"