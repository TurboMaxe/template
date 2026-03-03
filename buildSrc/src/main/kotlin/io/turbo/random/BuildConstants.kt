package io.turbo.random

import org.jetbrains.kotlin.konan.file.File

object BuildConstants { 
     // change immediately
     val name = "Plugin"
     // Main package class, expected to change this
     val main = "io.turbo.random.Main"
     // this is package, do not change
     val group = "io.turbo.random"
     // Change this when making big stuff, remove SNAPSHOT if it is not experimental
     val ver = "1.0-SNAPSHOT"
     // Paper's api version
     val api = "1.21"
     // not-needed boolean, just determmines if the plugin is in snapshot
     val IS_SNAPSHOT: Boolean = VERSION.contains("SNAPSHOT")
}
