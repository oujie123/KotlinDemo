package com.gacrnd.gcs.kotlin.net

import android.content.Context
import com.gacrnd.gcs.kotlin.LoadingDialog
import com.gacrnd.gcs.kotlin.entity.LoginResponseWrapper
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author Jack_Ou  created on 2020/8/3.
 */
abstract class APIResponse<T>(val context: Context) : Observer<LoginResponseWrapper<T>> {

    private var isShow: Boolean = true

    //用户可以选择调用主构造，调用主构造isShow 是true
    constructor(isShow: Boolean = false,context: Context): this(context){
        this.isShow = isShow
    }

    // ?修饰符表示可能为空
    abstract fun success(data: T?)

    abstract fun fail(msg: String?)

    override fun onSubscribe(d: Disposable) {
        if (isShow){
            LoadingDialog.show(context)
        }
    }

    override fun onNext(t: LoginResponseWrapper<T>) {
        if (t.data == null) {
            fail("登录失败，errorCode:${t.msg}")
        } else {
            success(t.data)
        }
    }

    override fun onError(e: Throwable) {
        LoadingDialog.cancel()
        fail(e.message)
    }

    override fun onComplete() {
        LoadingDialog.cancel()
    }
}