package com.gacrnd.gcs.kotlin.test.s03

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
    println("v1:$v1,v2:$v2,v3:$v3,v4:$v4")

    method()
    method(122,222)
}

//演示默认参数
fun method(n1:Int = 1,n2 : Int =2){
    println("n1:$n1,n2:$n2")
}