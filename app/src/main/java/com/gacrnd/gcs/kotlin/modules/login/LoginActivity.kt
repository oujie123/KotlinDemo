package com.gacrnd.gcs.kotlin.modules.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.gacrnd.gcs.kotlin.R
import com.gacrnd.gcs.kotlin.base.BaseActivity
import com.gacrnd.gcs.kotlin.config.Constant
import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse
import com.gacrnd.gcs.kotlin.modules.login.LoginPresenterImpl
import com.gacrnd.gcs.kotlin.modules.login.inner.LoginPresenter
import com.gacrnd.gcs.kotlin.modules.login.inner.LoginView
import com.gacrnd.gcs.kotlin.modules.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

//只做view相关的    此处是view的实现
class LoginActivity : BaseActivity<LoginPresenter>() ,LoginView{
    override fun createP(): LoginPresenter = LoginPresenterImpl(this@LoginActivity)

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun recycle() {
        presenter.unAttachView()
    }

    //通过父类来初始化了
    //private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //WanAndroidAPI.class 是java的写法     kotlin写法：WanAndroidAPI::class.java
        //val api: WanAndroidAPI = APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
        user_login_bt.setOnClickListener(onClickListener)
        user_register_tv.setOnClickListener(onClickListener)
        //loginPresenter = LoginPresenterImpl(this@LoginActivity)
    }

    private val onClickListener = View.OnClickListener {
        when (it.id){
            R.id.user_login_bt -> {
                val userName = user_phone_et.text.toString()
                val password = user_password_et.text.toString()
                Log.d(Constant.TAG,"userName:$userName, password:$password")
                presenter.loginAction(this@LoginActivity,userName,password)
            }
            R.id.user_register_tv -> {
                val intent = Intent(this@LoginActivity,RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun loginSuccess(loginRegisterBean: LoginRegisterResponse?) {
        Toast.makeText(this@LoginActivity,"成功",Toast.LENGTH_SHORT).show()
    }

    override fun loginFail(errorMsg: String?) {
        Toast.makeText(this@LoginActivity,"失败，$errorMsg",Toast.LENGTH_SHORT).show()
    }
}
