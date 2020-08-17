package com.gacrnd.gcs.kotlin.database

import androidx.room.*

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 21:44
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 21:44
 * @UpdateRemark:   数据库访问对象
 */
@Dao
interface StudentDao {

    @Insert
    fun insertStudents(vararg students: Student)

    @Update
    fun updateStudents(vararg students: Student)

    @Query(value = "DELETE FROM Student")
    fun deleteAllStudents()

    @Query(value = "SELECT * FROM Student ORDER BY ID DESC")
    fun queryAllStudents() : List<Student>

    @Delete
    fun deleteStudents(vararg students: Student)
}