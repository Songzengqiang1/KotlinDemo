package com.lkl.demo.bean
data class ResultData<T>(var code: Int, var message: String, var data: T?)

data class UserInfoVo(var userName: String, var password: String, var nickName: String)