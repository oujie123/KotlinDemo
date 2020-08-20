package com.gacrnd.gcs.kotlin.test.generic

import com.gacrnd.gcs.kotlin.test.generic.obj.ChildClass
import com.gacrnd.gcs.kotlin.test.generic.obj.ParentClass

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/20 23:59
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/20 23:59
 * @UpdateRemark:
 *
 * 读写权限模式
 *  java  extends       ------>   kotlin   out
 *  java  super         ------>   kotlin   in
 */

val parentClass = ParentClass()
val childClass = ChildClass()

fun test() {
    val list: MutableList<out ParentClass> = ArrayList<ChildClass>()
    //list自读  不能写
    val parentClass = list.get(0)
    //list.add(parentClass)

    val list1: MutableList<in ChildClass> = ArrayList<ParentClass>()
    //list可写不可读
    list1.add(childClass)
    //val childClass = list1.get(0)
}