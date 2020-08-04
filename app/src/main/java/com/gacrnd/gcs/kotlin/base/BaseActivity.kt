package com.gacrnd.gcs.kotlin.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

/**
 * @Author:         Jack Ou
 * @CreateDate:     2020/8/4 22:39
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/8/4 22:39
 * @UpdateRemark:   所有activity的父类
 */
//如果是限定一个接口可以这么写：abstract class BaseActivity <P : LoginPresenter>: AppCompatActivity()
//如果有两个  就需要这样写：abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter, P : Serializable
abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter{

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = createP()
        setContentView(getLayoutId())

        /**
         * 还可以让子类去initView()  initData()
         */
    }

    abstract fun createP() : P

    abstract fun getLayoutId() : Int

    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    //工具类都在这里写
    // 隐藏actionbar
    fun hideActionBar() {
        val actionBar : ActionBar? = supportActionBar
        actionBar?.hide()
    }

    //显示actionBar
    fun showActionBar(){
        supportActionBar?.show()
    }
}