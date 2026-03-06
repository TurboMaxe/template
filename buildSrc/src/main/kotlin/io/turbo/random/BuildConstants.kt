package io.turbo.random

object BuildConstants { 
     // change immediately
     val name = "Plugin"
     // this is package, do not change
     val group = "io.turbo.random"
     // Change this when making big stuff, remove SNAPSHOT if it is not experimental
     val ver = "1.0-SNAPSHOT"
     // Paper's api version
     val api = "1.21"
     // class where bukkit's java plugin is extended
     val main = "${group}.Main"
     // not-needed boolean, just determmines if the plugin is in snapshot
     val IS_SNAPSHOT: Boolean = ver.contains("SNAPSHOT")
}
