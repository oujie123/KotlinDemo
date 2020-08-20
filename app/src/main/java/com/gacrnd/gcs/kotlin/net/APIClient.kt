package com.gacrnd.gcs.kotlin.net

import com.gacrnd.gcs.kotlin.config.Constant.BASE_URL1
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Jack_Ou  created on 2020/8/3.
 */
class APIClient {

    //单例
    private object Holder{
        val INSTANCE = APIClient()
    }

    //派生，静态
    companion object {
        val instance = Holder.INSTANCE
    }

    fun <T> instanceRetrofit(apiInterface : Class<T>) : T {

        //改造前
        /*val mOkHttpClient = OkHttpClient().newBuilder()
            .readTimeout(10,TimeUnit.SECONDS)
            .connectTimeout(10,TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS)
            .build()*/

        //改造后
        val mOkHttpClient = OkHttpClient().newBuilder().myApply {
            readTimeout(10,TimeUnit.SECONDS)
            connectTimeout(10,TimeUnit.SECONDS)
            writeTimeout(10,TimeUnit.SECONDS)
        }.build()


        val retrofit : Retrofit = Retrofit.Builder()
            //请求方
            .baseUrl(BASE_URL1)
            .client(mOkHttpClient)

            //响应方配置
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(apiInterface)
    }
}

fun <T> T.myApply(mm: T.() -> T) : T {
    mm(this)
    return this
}