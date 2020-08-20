package com.gacrnd.gcs.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gacrnd.gcs.kotlin.test.toast
import com.gacrnd.gcs.kotlin.net.APIClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        APIClient.instance
        //扩展函数
        toast("12333")
    }
}
