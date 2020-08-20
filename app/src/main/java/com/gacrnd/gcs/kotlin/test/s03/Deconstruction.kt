package com.gacrnd.gcs.kotlin.test.s03

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 1:42
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 1:42
 * @UpdateRemark:   更新说明
 */
data class Deconstruction(val id: Int, val name: String, val sexy: Char)

fun main() {
    val u = Deconstruction(1, "JackOu", 'M')
    val (v1, v2, v3) = u.copy()
    println("vi:$v1,v2:$v2,v3:$v3")
}