package com.gacrnd.gcs.kotlin.modules.register

import android.content.Context
import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse
import com.gacrnd.gcs.kotlin.modules.register.inner.RegisterPresenter
import com.gacrnd.gcs.kotlin.modules.register.inner.RegisterView

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 0:30
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 0:30
 * @UpdateRemark:   更新说明
 */
class RegisterPresenterImpl(var registerView: RegisterView?) : RegisterPresenter, RegisterPresenter.OnRegisterListener {
    override fun registerSuccess(loginRegisterBean: LoginRegisterResponse?) {
        registerView?.registerSuccess(loginRegisterBean)
    }

    override fun registerFail(errorMsg: String?) {
        registerView?.registerFail(errorMsg)
    }

    private val registerModelImpl = RegisterModelImpl()
    override fun registerAction(context: Context, userName: String, password: String, repassword: String) {
        registerModelImpl.register(context, userName, password, repassword, this)
    }

    override fun unAttachView() {
        registerView = null
        registerModelImpl.cancelRequest()
    }
}