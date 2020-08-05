package com.gacrnd.gcs.kotlin.Test

/**
 * 高阶演示
 *
 * 一个方法可以完成一轮交互
 *
 * @author Jack_Ou  created on 2020/8/5.
 */
fun main() {
//    show(true) {
//        println("$it")
//        false
//    }

    loginInteraction("jackou","123456"){
        if (it){
            println("登录成功")
            return@loginInteraction "好的"
        } else {
            println("登录失败")
            return@loginInteraction "哎哎哎"
        }
    }
}

fun show(isLogin: Boolean, loginMethod: (String) -> Boolean) {
    if (isLogin) {
        println("登录成功")
        val t = loginMethod("HAHAHAHA")
        println(t)
    } else {
        println("登录失败")
        val t = loginMethod("55555")
        println(t)
    }
}

////使用userName，password去登录，然后将结果返回到调用方。调用方回复收到
fun loginInteraction(userName: String, password: String, loginResult: (Boolean) -> String) {
    val client = loginResult(login(userName,password))
    println("client response: $client")
}

fun login(userName: String, password: String) : Boolean{
    return false
}