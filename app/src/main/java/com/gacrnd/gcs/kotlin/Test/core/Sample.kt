package com.gacrnd.gcs.kotlin.Test.core

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/18 0:10
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/18 0:10
 * @UpdateRemark:   测试kt的lambda表达是
 */
fun main() {
    var method01: (Int, Int) -> Int   //该方法可以定义，但是无法调用，因为没有实现

    var method02: (Int, Boolean) -> Any?   //该方法可以定义，但是无法调用，因为没有实现

    //如果是：  使用小括号声明形参类型即可
    //如果是={} 必须在{}中注明形参类型
    var method03: (Int, Int) -> Int = { num1, num2 -> num1 + num2 }  //调用OK 因为有实现了
    println("method03 result:${method03(6, 6)}")

    var method04 = { num1: Int, num2: Int -> num1 + num2 }    //此时返回值是Int类型，因为编译器会根据num1和num2执行结果推断
    var method05 = { num1: Int, num2: Int -> num1 + num2.toDouble() }    //此时返回值是Double类型，因为编译器会根据num1和num2执行结果推断
    println("method04 result:${method04(6, 6)}")
    println("method05 result:${method05(6, 6)}")

    var method06 = { num1: Int, num2: Int -> println("$num1 + $num2 = ${num1 + num2}")
        num1 + num2
    }
    println("method06:result:${method06(1,2)}")

    /*=========================高阶===========================================*/
    loginEngine("jack","123")
}

//给高阶函数去一个别名
typealias RequestLogin = (String,String) -> Unit

private fun loginService(userName:String,userPwd:String, requestLogin: RequestLogin) : Unit{
    requestLogin(userName,userPwd)
}

fun loginEngine(userName:String,userPwd:String) : Unit{
    loginService(userName,userPwd){ name,pwd ->
        if(name == "jack" && pwd == "123"){
            println("登录成功")
        } else {
            println("登录失败")
        }
    }
}

