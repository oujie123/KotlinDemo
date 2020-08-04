package com.gacrnd.gcs.kotlin.entity

/**
 * @author Jack_Ou  created on 2020/8/3.
 */
data class LoginRegisterResponseWrapper<T>(val data: T, val code: Int, val msg: String)