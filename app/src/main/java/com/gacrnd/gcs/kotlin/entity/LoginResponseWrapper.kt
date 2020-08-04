package com.gacrnd.gcs.kotlin.entity

/**
 * @author Jack_Ou  created on 2020/8/3.
 */
data class LoginResponseWrapper<T>(val data: T, val code: Int, val msg: String)