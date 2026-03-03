package io.turbo.random

import org.jetbrains.kotlin.konan.file.File

object BuildConstants { 
     val name = "TurboPlugin"
     val main = "io.turbo.random.Main" 
     val group = 
     val ver = "1.0-SNAPSHOT"
     val api = "1.21"
    
     val IS_SNAPSHOT: Boolean = VERSION.contains("SNAPSHOT")
}
