package bran.cupid.www.baselib.eventbus;

import java.lang.reflect.Method;

/**
 * 作者: bran
 * 日期: 2019/10/27 0027
 * 描述：
 */
public class SubscribeMethod {
    private Method method;
    private ThreadMode threadMode;  //线程模式
    private Class<?> paramsType;  //参数类型

    public SubscribeMethod(Method method, ThreadMode threadMode, Class<?> paramsType) {
        this.method = method;
        this.threadMode = threadMode;
        this.paramsType = paramsType;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public ThreadMode getThreadMode() {
        return threadMode;
    }

    public void setThreadMode(ThreadMode threadMode) {
        this.threadMode = threadMode;
    }

    public Class<?> getParamsType() {
        return paramsType;
    }

    public void setParamsType(Class<?> paramsType) {
        this.paramsType = paramsType;
    }

    @Override
    public String toString() {
        return "SubscribeMethod{" +
                "method=" + method +
                ", threadMode=" + threadMode +
                ", paramsType=" + paramsType +
                '}';
    }
}
