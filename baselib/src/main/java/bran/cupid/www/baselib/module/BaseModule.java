package bran.cupid.www.baselib.module;

import java.io.Serializable;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class BaseModule<T> implements Serializable {
    public String code = "";
    public String msg = "";
    public String desc = "";
    public T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
