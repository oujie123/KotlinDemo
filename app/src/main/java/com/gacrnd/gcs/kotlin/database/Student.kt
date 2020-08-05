package com.gacrnd.gcs.kotlin.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 21:38
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 21:38
 * @UpdateRemark:   更新说明
 */
@Entity
class Student() {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "student_name")
    lateinit var name: String

    //数据库列名会优先设置的，没设置就以变量名为准
    @ColumnInfo(name = "age")
    var age: Int = 0

    constructor(name: String, age: Int) : this() {
        this.name = name
        this.age = age
    }
}