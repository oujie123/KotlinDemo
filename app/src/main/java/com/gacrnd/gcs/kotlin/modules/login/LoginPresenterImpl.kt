package com.gacrnd.gcs.kotlin.modules.login

import android.content.Context
import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse
import com.gacrnd.gcs.kotlin.modules.login.inner.LoginPresenter
import com.gacrnd.gcs.kotlin.modules.login.inner.LoginView

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/4 21:39
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/4 21:39
 * @UpdateRemark:   presenter的实现类
 */
class LoginPresenterImpl(var loginView: LoginView?) : LoginPresenter, LoginPresenter.OnLoginListener {

    /**
     * 需要module层用户调用login
     */
    private val loginModel: LoginModelImpl = LoginModelImpl()

    /**
     * 需要view回调状态，所以要实现view接口
     * 再构造函数中传入View
     */

    /**
     * 以下三个方法是请求和回调
     */
    override fun loginAction(context: Context, userName: String, password: String) {
        //此处应该对username和password做很多有效性校验的，此处省略直接调用
        loginModel.login(context, userName, password, this)
    }

    override fun unAttachView() {
        loginView = null
        loginModel.cancelRequest()
    }

    override fun loginFail(errorMsg: String?) {
        loginView?.loginFail(errorMsg)
    }

    override fun loginSuccess(loginRegisterBean: LoginRegisterResponse?) {
        loginView?.loginSuccess(loginRegisterBean)
    }

}