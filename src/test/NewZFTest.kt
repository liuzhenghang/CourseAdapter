package test

import parser.NewZFParser
import java.io.File

fun main() {
    val path = "/Users/yzune/YZune_Git/database/python/schools/武汉轻工大学"
    val file = File(path)
    val fs = file.listFiles()
    fs?.forEach {
        if (it.isDirectory) return
        val content = it.readText()
        try {
            NewZFParser(content).saveCourse()
            println("↑" + it.name)
            println()
        } catch (e: Exception) {
            if (content.contains("星期一") && content.contains("星期二") && content.contains("节次")) {
                e.printStackTrace()
                println("↑" + it.name)
                println()
            }
        }
    }
}