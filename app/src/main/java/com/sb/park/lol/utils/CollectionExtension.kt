package com.sb.park.lol.utils

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList

internal fun <T> List<T>?.toImmutableList(): ImmutableList<T> = this?.toImmutableList() ?: persistentListOf()

internal fun <T> List<T>?.toPersistentList(): PersistentList<T> = this?.toPersistentList() ?: persistentListOf()