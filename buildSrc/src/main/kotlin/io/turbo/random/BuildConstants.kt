package io.turbo.random

import org.jetbrains.kotlin.konan.file.File

object BuildConstants {
     const val VERSION = "1.0.0"
     const val API_VERSION = "1.21."
    
     val IS_SNAPSHOT: Boolean = VERSION.contains("SNAPSHOT")
}
