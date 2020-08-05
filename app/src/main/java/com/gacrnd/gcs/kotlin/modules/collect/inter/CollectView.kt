package com.xiangxue.kotlinproject.modules.collect.inter

import com.gacrnd.gcs.kotlin.database.Student

interface CollectView {

    // 显示数据  --- 》 View

    fun showResultSuccess(result: List<Student> ?)

    fun showResult(result: Boolean)
}