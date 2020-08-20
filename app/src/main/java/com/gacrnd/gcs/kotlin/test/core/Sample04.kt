package com.gacrnd.gcs.kotlin.test.core

/**
 * Apply 的用法   实现链式调用
 *
 * @author Jack_Ou  created on 2020/8/19.
 */
val name1: String = "JackOu"

fun main() {
    val length03: Int = name1.myApply {

    }.myApply {

    }.myApply {

    }.length

    val length01: Int = name1.length

    val length02 = name1.myAlso {

    }.myAlso {

    }.myAlso {

    }.length

    name.myLet5 {
        //此处的it == T == this == name   单纯的传了一个参数，此时直接用length会报错
        //length   报错
        //it.length  对
    }

    name.myLet3 {
        //此时是变量就是this 也是name
        length //直接写length
    }

    name.myLet4 {
        println(this)
    }

    name.let {
        // fun返回什么 let就返回什么
    }
}

//实现链式调用  默认无参数的
fun <T> T.myApply(mm: () -> Unit): T {
    mm()
    // 这里的T == this
    return this
}

//有参数的
fun <T> T.myAlso(mm: (T) -> Unit): T {
    mm(this)
    return this
}

fun <T, R> T.myLet5(mm: (T) -> R): R = mm(this)

//给T增加一个匿名扩展函数，参数是T
fun <T, R> T.myLet3(mm: T.(T) -> R): R {
    return mm(this)
}

//实现函数还是会以原来的T为基准,传入的无效
fun <T, R> T.myLet4(mm: T.(String) -> R): R {
    return mm("ojjj")
}