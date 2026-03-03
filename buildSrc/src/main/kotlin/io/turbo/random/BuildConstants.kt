package io.turbo.random

import org.jetbrains.kotlin.konan.file.File

object BuildConstants {
    private val ROOT_DIR: File by lazy {
        var dir = File(System.getProperty("user.dir"))
        while (!File(dir, ".git").exists && dir.parentFile.exists) {
            dir = dir.parentFile
        }
        dir
    }
