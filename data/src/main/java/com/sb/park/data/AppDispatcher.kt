package com.sb.park.data

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class Dispatcher(val appDispatchers: AppDispatchers)
internal enum class AppDispatchers {
    IO
}