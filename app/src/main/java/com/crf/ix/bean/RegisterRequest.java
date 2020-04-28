package com.crf.ix.bean;

import java.util.HashMap;

/**
 * @ClassName: RegisterRequest
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/18 16:17
 */
public class RegisterRequest {

    private String mobile;
    private String smsCode;
    private String channel;
    private String loginPwd;
    private String osVersion;
    private String deviceId;


    public RegisterRequest() {
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
