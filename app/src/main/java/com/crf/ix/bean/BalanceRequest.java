package com.crf.ix.bean;

/**
 * @ClassName: BalanceRequest
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/17 14:40
 */
public class BalanceRequest {

    public String business_type;
    public String externalAccount;
    public String queryDay;

    public BalanceRequest(String business_type, String externalAccount, String queryDay) {
        this.business_type = business_type;
        this.externalAccount = externalAccount;
        this.queryDay = queryDay;
    }


}
