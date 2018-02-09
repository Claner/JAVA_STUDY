package javaStudy.connectionPoolDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * Created by Clanner on 2018/2/6.
 * 构造Connection
 */
public class ConnectionDriver {
    static class ConnectionHolder implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //这里的Connection只是一个接口，最终的实现是由数据库驱动提供的，这里是示例所以先返回null
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    //创建一个Connection的代理，在commit时休眠100毫秒
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class<?>[]{Connection.class}, new ConnectionHolder());
    }
}
