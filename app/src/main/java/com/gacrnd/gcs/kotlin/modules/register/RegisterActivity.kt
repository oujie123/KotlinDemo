package com.gacrnd.gcs.kotlin.modules.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gacrnd.gcs.kotlin.R
import com.gacrnd.gcs.kotlin.base.BaseActivity
import com.gacrnd.gcs.kotlin.entity.LoginRegisterResponse
import com.gacrnd.gcs.kotlin.modules.login.LoginActivity
import com.gacrnd.gcs.kotlin.modules.register.inner.RegisterPresenter
import com.gacrnd.gcs.kotlin.modules.register.inner.RegisterView
import kotlinx.android.synthetic.main.activity_user_register.*

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/5 0:19
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/5 0:19
 * @UpdateRemark:   更新说明
 */
class RegisterActivity : BaseActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user_register_bt.setOnClickListener(listener)
    }

    private val listener = View.OnClickListener {
        when (it.id) {
            R.id.user_register_bt -> {
                val username = user_phone_et.text.toString()
                val password = user_password_et.text.toString()
                presenter.registerAction(this@RegisterActivity, username, password, password)
            }
        }
    }

    override fun createP(): RegisterPresenter = RegisterPresenterImpl(this)

    override fun registerSuccess(loginRegisterBean: LoginRegisterResponse?) {
        Toast.makeText(this@RegisterActivity, "成功", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun registerFail(errorMsg: String?) {
        Toast.makeText(this@RegisterActivity, "失败，error$errorMsg", Toast.LENGTH_SHORT).show()
    }

    override fun getLayoutId(): Int = R.layout.activity_user_register

    override fun recycle() {
        presenter.unAttachView()
    }
}