package com.gacrnd.gcs.kotlin.modules.register.inner

import android.content.Context
import com.gacrnd.gcs.kotlin.base.IBasePresenter
import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 0:20
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 0:20
 * @UpdateRemark:   更新说明
 */
interface RegisterPresenter : IBasePresenter {

    fun registerAction(context: Context, userName: String, password: String, repassword:String)

    interface OnRegisterListener{
        fun registerSuccess(loginRegisterBean: LoginRegisterResponse?)

        fun registerFail(errorMsg: String?)
    }
}