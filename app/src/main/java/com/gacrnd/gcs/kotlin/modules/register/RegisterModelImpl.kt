package com.gacrnd.gcs.kotlin.modules.register

import android.content.Context
import android.util.Log
import com.gacrnd.gcs.kotlin.api.WanAndroidAPI
import com.gacrnd.gcs.kotlin.config.Constant
import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse
import com.gacrnd.gcs.kotlin.modules.register.inner.RegisterModel
import com.gacrnd.gcs.kotlin.modules.register.inner.RegisterPresenter
import com.gacrnd.gcs.kotlin.net.APIClient
import com.gacrnd.gcs.kotlin.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 0:29
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 0:29
 * @UpdateRemark:   更新说明
 */
class RegisterModelImpl : RegisterModel{
    override fun cancelRequest() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(
        context: Context,
        userName: String,
        password: String,
        repassword: String,
        onRegisterListener: RegisterPresenter.OnRegisterListener
    ) {
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .registerAction(userName,password,repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APIResponse<LoginRegisterResponse>(context){
                override fun success(data: LoginRegisterResponse?) {
                    Log.e(Constant.TAG,"data:$data")
                    onRegisterListener.registerSuccess(data)
                }

                override fun fail(msg: String?) {
                    Log.e(Constant.TAG,"errorMsg:$msg")
                    onRegisterListener.registerFail(msg)
                }
            })
    }
}