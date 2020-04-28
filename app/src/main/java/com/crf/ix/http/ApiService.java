package com.crf.ix.http;


import com.crf.ix.bean.LoginBean;
import com.crf.ix.bean.Test;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @ClassName: ApiService
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/3 11:22
 */
public interface ApiService {
    //注册获取验证码
    @GET("/v1/customer/sendVerifyCode")
    Observable<Test> send(@Query("mobile") String phone,@Query("osVersion") String osVersion,@Query("deviceId") String deviceId);

    //注册
    @POST("v1/customer/customerRegister")
    Observable<Test> register(@Body RequestBody body);

    //登录
    @POST("user/login")
    Observable<LoginBean> login(@Body RequestBody body);

    //余额查询
    @POST
    Observable<Test> getBalance(@Url String url,@Body RequestBody body);

    //充值
    @POST
    Observable<Test> charge(@Url String url,@Body RequestBody body);

    //提现
    @POST("http://10.194.11.189:8762/v1/accountTrans/withdraw")
    Observable<Test> withDraw(@Body RequestBody body);
}
