package com.gacrnd.gcs.kotlin.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.gacrnd.gcs.kotlin.R
import com.gacrnd.gcs.kotlin.api.WanAndroidAPI
import com.gacrnd.gcs.kotlin.config.Constant
import com.gacrnd.gcs.kotlin.entity.LoginResponse
import com.gacrnd.gcs.kotlin.entity.LoginResponseWrapper
import com.gacrnd.gcs.kotlin.net.APIClient
import com.gacrnd.gcs.kotlin.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //WanAndroidAPI.class 是java的写法     kotlin写法：WanAndroidAPI::class.java
        //val api: WanAndroidAPI = APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
        user_login_bt.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        when (it.id){
            R.id.user_login_bt -> {
                val userName = user_phone_et.text.toString()
                val password = user_password_et.text.toString()
                Log.d(Constant.TAG,"userName:$userName, password:$password")
                APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
                    .login(userName,password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : APIResponse<LoginResponse>(this){
                        override fun success(data: LoginResponse?) {
                            Log.e(Constant.TAG,"data:$data")
                            Toast.makeText(this@LoginActivity,"成功",Toast.LENGTH_LONG).show()
                        }

                        override fun fail(msg: String?) {
                            Log.e(Constant.TAG,"errorMsg:$msg")
                            Toast.makeText(this@LoginActivity,"失败",Toast.LENGTH_LONG).show()
                        }
                    })
//                    .subscribe(object : Consumer<LoginResponseWrapper<LoginResponse>>{
//                        override fun accept(t: LoginResponseWrapper<LoginResponse>?) {
//                            //此处需要拆包更新UI
//                        }
//
//                    })
            }
        }
    }
}
