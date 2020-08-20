package com.gacrnd.gcs.kotlin.Test.core

/**
 * @author Jack_Ou  created on 2020/8/19.
 */
fun main() {
    // ::将方法交给run01执行
    show01(::run01)

    // ::将run01变成函数类型的对象，可以用变量来接收
    val r01 = ::run01
    val r02 = r01
    show01(r01)
}

fun show01(mm: (Int) -> String) {
    println(mm(11))
}

fun run01(number: Int): String = "ok,$number"