package com.gacrnd.gcs.kotlin.modules.login.inner

import android.content.Context
import com.gacrnd.gcs.kotlin.base.IBasePresenter
import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/4 21:25
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/4 21:25
 * @UpdateRemark:   Presenter层
 */
interface LoginPresenter : IBasePresenter {
    fun loginAction(context: Context, userName: String, password: String)

    interface OnLoginListener{
        fun loginSuccess(loginRegisterBean: LoginRegisterResponse?)

        fun loginFail(errorMsg: String?)
    }
}