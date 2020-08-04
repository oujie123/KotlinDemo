package com.gacrnd.gcs.kotlin.api

import com.gacrnd.gcs.kotlin.entity.LoginResponse
import com.gacrnd.gcs.kotlin.entity.LoginResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author Jack_Ou  created on 2020/8/3.
 */
interface WanAndroidAPI {

    /**
     * 登录，表单方式提交
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun login(@Field("username") username:String,
              @Field("password") password:String)
    :Observable<LoginResponseWrapper<LoginResponse>>


}