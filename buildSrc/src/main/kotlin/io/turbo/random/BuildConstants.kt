package io.turbo.random

object BuildConstants { 
     
     var name = ""
     val group = "io.turbo.random"
     var ver = "1.0-b1"
     val api = "1.21"
     var main = "${group}.Main"
     // is plugin in beta ver?
     val IS_BETA: Boolean = ver.contains("b")
}
