package com.gacrnd.gcs.kotlin.test.core

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/18 23:45
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/18 23:45
 * @UpdateRemark:   更新说明
 */
val name: String = "JackOu"
val age: Int = 10

fun common() {
    println("我是普通方法")
}

fun main() {
    //name.myRun<>()
    //使用高阶函数
    println(common().myRun {
        println("AAAAAA")
        //此处需要返回R，R是一个泛型，以最后返回确定类型
        true  //返回boolean
        111.11 //返回double类型
    })

    name.myLet {
        println(length)
    }

    //执行控制器
    onRun(true) {
        println("控制器执行了")
    }

    val r = Runnable {
        println("Runnable is running")
    }
    onRun(true, r::run)
}

/**
 * 扩展函数
 * 1.给T增加扩展函数
 * 2.在给扩展函数指定匿名函数
 */
//高阶函数m: T.() -> R     T.()表示匿名函数
//fun <T, R> T.myRun(m: T.() -> R): R {
//    return m()
//}

//普通高阶函数，传入参数为空
fun <T, R> T.myRun(m: () -> R): R {
    return m()
}

//fun <T, R> T.myRun(m: () -> R): R = m()

//T == this   () -> R
//fun <T, R> T.myLet(mm: (T) -> R): R {
//    return mm(this)
//}

//如果是采用匿名函数，就可以不用this
//mm(this) == this     T.(T) -> R
fun <T, R> T.myLet(mm: T.(T) -> R): R {
    return mm(this)
}

//控制器  如果是真的就会执行高阶函数
fun onRun(isRun: Boolean, mm: () -> Unit) {
    if (isRun) mm()
}