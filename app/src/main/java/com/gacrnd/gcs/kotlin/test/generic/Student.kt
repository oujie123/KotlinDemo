package com.gacrnd.gcs.kotlin.test.generic

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/21 0:14
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/21 0:14
 * @UpdateRemark:   在类申明中定义，一劳永逸，后面就不用限制了
 */
// T只能写   不能读
class Student<in T> {

    fun setData(data: T) {}

    fun addData(data: T) {}

    //fun getData() :T? = null   //如果是获取，编译都通不过
}