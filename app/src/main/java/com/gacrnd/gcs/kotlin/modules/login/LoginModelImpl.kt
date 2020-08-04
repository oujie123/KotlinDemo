package com.gacrnd.gcs.kotlin.modules.login

import android.content.Context
import android.util.Log
import com.gacrnd.gcs.kotlin.api.WanAndroidAPI
import com.gacrnd.gcs.kotlin.config.Constant
import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse
import com.gacrnd.gcs.kotlin.modules.login.inner.LoginModel
import com.gacrnd.gcs.kotlin.modules.login.inner.LoginPresenter
import com.gacrnd.gcs.kotlin.net.APIClient
import com.gacrnd.gcs.kotlin.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/4 21:40
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/4 21:40
 * @UpdateRemark:   module的实现层
 */
class LoginModelImpl : LoginModel{
    override fun login(
        context: Context,
        userName: String,
        password: String,
        onLoginListener: LoginPresenter.OnLoginListener
    ) {
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .login(userName,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APIResponse<LoginRegisterResponse>(context){
                override fun success(data: LoginRegisterResponse?) {
                    Log.e(Constant.TAG,"data:$data")
                    onLoginListener.loginSuccess(data)
                }

                override fun fail(msg: String?) {
                    Log.e(Constant.TAG,"errorMsg:$msg")
                    onLoginListener.loginFail(msg)
                }
            })
    }

    override fun cancelRequest() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}