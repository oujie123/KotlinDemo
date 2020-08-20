package com.gacrnd.gcs.kotlin.test.core

/**
 * @author Jack_Ou  created on 2020/8/20.
 */
fun main() {
    val thread = ktRun(true, null) {
        println("线程执行")
        doCycles(10){
            println("当前的索引是$it")
        }
    }
    println(thread.name)
}

//自定义循环
fun doCycles(number: Int, mm: (Int) -> Unit) {
    for (index in 0 until number) {
        mm(index)
    }
}

//自定义线程
fun ktRun(
    start: Boolean = true,
    name: String? = null,
    mm: () -> Unit
): Thread {
    val name = name ?: "JackOu"
    val thread = object : Thread(name) {
        override fun run() {
            super.run()
            mm()
        }
    }
    if (start) {
        thread.start()
    }
    return thread
}