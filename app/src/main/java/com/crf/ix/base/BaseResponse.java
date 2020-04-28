package com.crf.ix.base;

/**
 * @ClassName: BaseResponse
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/21 18:39
 */
public class BaseResponse<T> {
    private int code;
    private String info;
    private T data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", info='" + info + '\'' +
                ", data=" + data +
                '}';
    }
}
