package com.gacrnd.gcs.kotlin.entity

/**
 *
 * "data": {
"admin": false,
"chapterTops": [],
"collectIds": [],
"email": [],
"icon": "",
"id": 66720,
"nickname": "Derry-vip",
"password": "",
"publicName": "Derry-vip",
"token": "",
"type": 0,
"username": "Derry-vip"
}
 *
 * 登录成功将这个bean给UI
 * @author Jack_Ou  created on 2020/8/3.
 */
// *通配符   ?允许字段为null
data class LoginRegisterResponse(val admin:Boolean,
                                 val chapterTops: List<*>,
                                 val collectIds: List<*>,
                                 val email: String?,
                                 val icon:String?,
                                 val id: String?,
                                 val nickname: String?,
                                 val password: String?,
                                 val publicName: String?,
                                 val token: String?,
                                 val type: Int,
                                 val username: String?)