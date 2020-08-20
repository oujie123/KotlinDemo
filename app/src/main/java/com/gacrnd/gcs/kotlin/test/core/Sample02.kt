package com.gacrnd.gcs.kotlin.Test.core

/**
 * @author Jack_Ou  created on 2020/8/19.
 */
fun main() {
    //写法1
    show1("Jack") {
        println("result:$it")
    }
    //写法2
    show1("Jack1", mm = {
        println("result:$it")
    })
    //写法3
    show1("Jack2", {
        println("result:$it")
    })

    //写法4
    show1 { println("result:$it") }

    //写法5    写两个参数  必须指明参数
    sun1 { n1, b1 ->
        println("result:$n1,$b1")
    }
}

fun show1(name: String = "yibaobao", mm: (String) -> Unit) {
    mm(name)
}

fun sun1(mm: (Int, Boolean) -> Unit) {
    mm(10, true)
}