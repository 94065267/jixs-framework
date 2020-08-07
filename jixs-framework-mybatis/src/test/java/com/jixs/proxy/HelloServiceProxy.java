package com.jixs.proxy;

import com.jixs.service.HelloServiceImpl;
import com.jixs.service.IHelloService;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理
 * @author: jixs
 * @date: 2020-07-29
 */
@Slf4j
public class HelloServiceProxy<T> implements InvocationHandler {
    /**
     * 代理对象
     */
    private Object target;

    @SuppressWarnings("unchecked")
    public T newInstance(Object target) {
        this.target = target;
        // jdk产生一个代理对象
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("JDK动态代理：{}，method={}", proxy.getClass().getName(), method.getName());
        log.info("method.getModifiers() = " + method.getModifiers());
        log.info("" + (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC));
        log.info("" + ((method.getModifiers() & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC));
        log.info("" + method.getDeclaringClass().isInterface());
        return method.invoke(this.target, args);
    }

    public static void main(String[] args) {
        HelloServiceProxy<IHelloService> proxyHandle = new HelloServiceProxy<>();
        IHelloService helloService = proxyHandle.newInstance(new HelloServiceImpl());
        helloService.sayHello("小快乐");
    }
}
