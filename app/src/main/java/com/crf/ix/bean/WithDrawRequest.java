package com.crf.ix.bean;

/**
 * @ClassName: ChargeRequest
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/17 15:16
 */
public class WithDrawRequest {
    private String agentBusinessType;
    private String applyTime;
    private String bankCode;
    private String business_type;


    private String callBackUrl;
    private String externalAccount;
    private String requestRefNo;
    private String transferAmount;
    private String userName;

    public WithDrawRequest() {
    }

    public void setAgentBusinessType(String agentBusinessType) {
        this.agentBusinessType = agentBusinessType;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public void setExternalAccount(String externalAccount) {
        this.externalAccount = externalAccount;
    }

    public void setRequestRefNo(String requestRefNo) {
        this.requestRefNo = requestRefNo;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
