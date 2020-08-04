package com.gacrnd.gcs.kotlin.modules.register.inner

import android.content.Context
import com.gacrnd.gcs.kotlin.modules.login.inner.LoginPresenter

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 0:26
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 0:26
 * @UpdateRemark:   更新说明
 */
interface RegisterModel {

    //取消请求
    fun cancelRequest()

    //登陆
    //接口回调给presenter
    fun register(
        context: Context,
        userName: String,
        password: String,
        repassword: String,
        onRegisterListener: RegisterPresenter.OnRegisterListener
    )
}