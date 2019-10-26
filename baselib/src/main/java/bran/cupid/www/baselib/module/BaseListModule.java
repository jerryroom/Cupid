package bran.cupid.www.baselib.module;

import java.io.Serializable;
import java.util.List;

//针对返回 data 为集合的时候
public class BaseListModule<D> implements Serializable{

    public String code = "";
    public String msg = "";
    public String desc = "";
    public List<D> data;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }

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

    public List<D> getData() {
        return data;
    }

    public void setData(List<D> data) {
        this.data = data;
    }
}
