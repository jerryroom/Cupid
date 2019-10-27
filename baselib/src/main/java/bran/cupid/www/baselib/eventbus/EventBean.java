package bran.cupid.www.baselib.eventbus;

import java.io.Serializable;

/**
 * 作者: bran
 * 日期: 2019/10/27 0027
 * 描述：
 */
public class EventBean implements Serializable {
    public String key;
    public Object value;

    public EventBean(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}
