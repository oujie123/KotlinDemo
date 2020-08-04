package com.gacrnd.gcs.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gacrnd.gcs.kotlin.R
import com.gacrnd.gcs.kotlin.net.APIClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        APIClient.instance

    }
}
