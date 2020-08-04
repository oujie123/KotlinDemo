package com.gacrnd.gcs.kotlin.modules.login.inner

import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/4 21:23
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/4 21:23
 * @UpdateRemark:   View层
 */
interface LoginView {

    fun loginSuccess(loginRegisterBean: LoginRegisterResponse?)

    fun loginFail(errorMsg: String?)
}