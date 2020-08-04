package com.gacrnd.gcs.kotlin.modules.register.inner

import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 0:23
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 0:23
 * @UpdateRemark:   更新说明
 */
interface RegisterView {

    fun registerSuccess(loginRegisterBean: LoginRegisterResponse?)

    fun registerFail(errorMsg: String?)
}