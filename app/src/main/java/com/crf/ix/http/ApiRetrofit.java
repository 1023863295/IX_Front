package com.crf.ix.http;

import com.crf.ix.bean.BalanceRequest;
import com.crf.ix.bean.ChargeRequest;
import com.crf.ix.bean.LoginBean;
import com.crf.ix.bean.RegisterRequest;
import com.crf.ix.bean.Test;
import com.crf.ix.bean.WithDrawRequest;
import com.crf.ix.global.Configs;
import com.crf.ix.utils.DateUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @ClassName: ApiRetrofit
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/3 11:21
 */
public class ApiRetrofit extends BaseApiRetrofit{
    private ApiService api;
    public static ApiRetrofit mInstance;

    private ApiRetrofit() {
        super();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //在构造方法中完成对Retrofit接口的初始化
        api = new Retrofit.Builder()
                .baseUrl(Configs.ROOT_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(ApiService.class);

    }

    public static ApiRetrofit getInstance() {
        if (mInstance == null) {
            synchronized (ApiRetrofit.class) {
                if (mInstance == null) {
                    mInstance = new ApiRetrofit();
                }
            }
        }
        return mInstance;
    }

    private RequestBody getRequestBody(Object obj) {
        String route = new Gson().toJson(obj);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route);
        return body;
    }

    //登录
//    public Observable<Test> login(String region, String phone, String password) {
//
//    }

    //注册页面获取验证码
    public Observable<Test> sendCode(String phone) {
        return api.send(phone,"android","123456789");
    }

    //注册注册
    public Observable<Test> register(String mobile,String smsCode,String channel,String loginPwd,String osVersion,String deviceId) {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setMobile(mobile);
        registerRequest.setSmsCode(smsCode);
        registerRequest.setChannel(channel);
        registerRequest.setLoginPwd(loginPwd);
        registerRequest.setOsVersion(osVersion);
        registerRequest.setDeviceId(deviceId);
        return api.register(getRequestBody(registerRequest));
    }

    //余额查询
    public Observable<Test> getBalance(String accout){
        return  api.getBalance("http://10.194.11.189:8762/v1/accountTrans/balanceQuery",
                getRequestBody(new BalanceRequest("rcs",
                accout, DateUtils.getStringDate())));
    }

    //充值
    public Observable<Test> charge(ChargeRequest chargeRequest){
        return  api.charge("http://10.194.11.189:8762/v1/accountTrans/recharge",getRequestBody(chargeRequest));
    }

    //提现
    public Observable<Test> withDraw(WithDrawRequest withDrawRequest){
        return api.withDraw(getRequestBody(withDrawRequest));
    }


}
