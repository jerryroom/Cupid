package bran.cupid.www.baselib.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import bran.cupid.www.baselib.util.BaseUtils;
import bran.cupid.www.baselib.util.LogUtils;

/**
 * 作者: bran
 * 日期: 2019/10/27 0027
 * 描述：
 */
public class EventBus {
    private static final String TAG = "EventBus";
    private static EventBus eventBus;
    private HashMap<Object, List<SubscribeMethod>> map;

    private EventBus() {
        map = new HashMap<>();
    }

    public static EventBus getEventBus() {
        if (eventBus == null) {
            synchronized (EventBus.class) {
                if (eventBus == null) {
                    eventBus = new EventBus();
                }
            }
        }
        return eventBus;
    }

    public void register(Object object) {
        List<SubscribeMethod> subscribeMethods = map.get(object);
        if (BaseUtils.listIsEmpty(subscribeMethods)) { //没注册过，先注册
            subscribeMethods = getSubscribeMethod(object);
            map.put(object, subscribeMethods);
        } else {

        }
    }

    private List<SubscribeMethod> getSubscribeMethod(Object object) {
        List<SubscribeMethod> methodList = new ArrayList<>();
        Class<?> registerObj = object.getClass();
        Method[] declaredMethods = registerObj.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            // 根据注解进行筛选
            Subscribe annotation = declaredMethod.getAnnotation(Subscribe.class);
            if (annotation == null) {
                continue;
            }
            //拿到参数
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if (parameterTypes == null || parameterTypes.length != 1) {
                LogUtils.e(TAG, "应该有且只有一个参数");
            }
            //根据注解拿到注解值
            ThreadMode threadMode = annotation.threadMode();

            SubscribeMethod method = new SubscribeMethod(declaredMethod, threadMode, parameterTypes[0]);
            methodList.add(method);
        }
        return methodList;
    }

    public void post(Object type) {
        Set<Object> objects = map.keySet();
        for (Object object : objects) {
            List<SubscribeMethod> methodList = map.get(object);
            for (SubscribeMethod subscribeMethod : methodList) {
                Class<?> paramsType = subscribeMethod.getParamsType();
                if (paramsType.isAssignableFrom(type.getClass())) {
                    Method method = subscribeMethod.getMethod();
                    try {
                        method.invoke(object, type);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
