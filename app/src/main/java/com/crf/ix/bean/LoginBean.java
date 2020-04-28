package com.crf.ix.bean;

import com.crf.ix.base.BaseResponse;

/**
 * @ClassName: LoginBean
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/3 9:30
 */
public class LoginBean extends BaseResponse {

    private String region;
    private String phone;
    private String password;

    public LoginBean(String region, String phone, String password) {
        this.region = region;
        this.phone = phone;
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

