package com.gacrnd.gcs.kotlin

import android.app.Dialog
import android.content.Context

/**
 * object没有主构造和次构造方法
 *
 * @author Jack_Ou  created on 2020/8/4.
 */
object LoadingDialog {

    private var dialog: Dialog? = null

    /**
     *  @JvmStatic  是真正的静态代码，如果没有这个表示，是kotlin单例调用的
     */
    @JvmStatic
    fun show(context: Context) {
        cancel()

        dialog = Dialog(context)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }

    fun cancel(){
        dialog?.dismiss()
    }
}