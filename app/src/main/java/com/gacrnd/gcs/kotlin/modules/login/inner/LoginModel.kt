package com.gacrnd.gcs.kotlin.modules.login.inner

import android.content.Context
import java.util.*

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/4 21:27
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/4 21:27
 * @UpdateRemark:   module层
 */
interface LoginModel {

    //取消请求
    fun cancelRequest()

    //登陆
    //接口回调给presenter
    fun login(context: Context, userName: String, password: String, onLoginListener: LoginPresenter.OnLoginListener)
}