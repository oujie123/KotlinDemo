package com.gacrnd.gcs.kotlin.test.s04

import java.io.File

/**
 * 扩展函数
 * @author Jack_Ou  created on 2020/8/5.
 */
fun main() {
    Student().read("Jack",18)
    val file = File("////")
    file.readText()
}

fun Student.read(name: String, age: Int) {
    println("$name,$age")
}