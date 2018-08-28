package com.lkl.demo.https

import com.lkl.demo.bean.ResultData
import com.lkl.demo.bean.UserInfoVo
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
interface ApiService {
    @POST("m/login")
    @FormUrlEncoded
    fun userLogin(@FieldMap options: Map<String, String>): Observable<ResultData<UserInfoVo>>
}