package com.gacrnd.gcs.kotlin.Test.s02

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 1:17
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 1:17
 * @UpdateRemark:   方法隔离
 */
fun show(name: String) {
    println(name)
}

fun `show2`(name:String){
    println(name)
}

//不能通过··访问到，但是可以通过静态类+方法访问
//··的意思是将很多怪怪的字符强行转化成可以用
fun `showTest`() {
    println("showTest")
}

//隐藏函数
fun `   `(name: String){
    println(name)
}

//随意混淆函数名
fun `4561389789`(name:String){
    println(name)
}

fun main(){
    `showTest`()
    `   `("JackOu")
    `4561389789`("JackOu1")
}