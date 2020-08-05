package com.gacrnd.gcs.kotlin.Test.s03

/**
 * 解构功能 operator关键词
 * @author Jack_Ou  created on 2020/8/5.
 */
class Student(var id: Int, var name: String, var sex: Char) {
    operator fun component1(): Int = id
    operator fun component2(): String = name
    operator fun component3(): Char = sex
    operator fun component4(): String = "Jack Ou Learn"
}

fun main() {
    val student = Student(1,"Jack",'m')
    val(v1,v2,v3,v4) = student
    println()
}