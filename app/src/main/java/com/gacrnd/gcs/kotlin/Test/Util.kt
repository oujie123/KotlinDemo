package com.gacrnd.gcs.kotlin.Test

import android.icu.text.IDNA
import javax.xml.transform.Source
import kotlin.reflect.KClass

/**
 * @author Jack_Ou  created on 2020/8/4.
 */
class MyUtils {
    fun show1(info: String) {
        println(info)
    }
}

//这种是会自动生成静态方法
fun show(info: String) {
    println(info)
}

fun main() {
    //使用``来解决关键字冲突
    println(Student.`in`)
    println(Student.test)

    //在应用的使用返回一个带！号的  需要我们处理这个！  建议用一个变量来接收，防止直接调用crash
    //从java调过来的代码需要做防空处理
    val string: String? = Student.getString()
    println(string?.length)

    //传java的类
    show1(Student::class.java)

    //传kotlin的class
    show2(KtStudent::class)

    //TODO 调用java的callback
    //第一种调用   不用重写
    CallbackManager().setCallback(JavaCallback {
        println(it)
    })

    //第二种使用回调的写法
    CallbackManager().setCallback(object : JavaCallback{
        override fun show(info: String?) {
            println(info?.length)
        }
    })

    //第三种，使用lambda表达式的
    CallbackManager().setCallback{ info: String? -> println(info) }

    //第四种
    val callback = JavaCallback {
        println(it)
    }
    CallbackManager().setCallback(callback)

    //TODO 调用kotlin的callback
    KtCallbackManager().setCallback(object : KtCallback{
        override fun show(name: String) {
            println(name)
        }
    })

    //第二种 java的可以不加object   kotlin 的必须加object
    val cb = object : KtCallback{
        override fun show(name: String) {
            println(name)
        }
    }
    KtCallbackManager().setCallback(cb)
}

//使用java形参
fun show1(clazz:Class<Student>){
    println(clazz.simpleName)
}

//使用kotlin的class
fun show2(clazz: KClass<KtStudent>){
    println(clazz.simpleName)
}