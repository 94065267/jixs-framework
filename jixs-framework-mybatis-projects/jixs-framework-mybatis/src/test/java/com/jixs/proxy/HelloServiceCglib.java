package com.jixs.proxy;

import com.jixs.service.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理
 *
 * @author: jixs
 * @date: 2020-07-29
 */
@Slf4j
public class HelloServiceCglib<T> implements MethodInterceptor {
    /**
     * 代理对象
     */

    @SuppressWarnings("unchecked")
    public T newInstance(Object target) {
        //创建一个Java代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("cglib代理：{}，method={},objects={},methodProxy={}", o.getClass().getName(), method.getName(), objects, methodProxy.getClass().getName());
        return methodProxy.invokeSuper(o, objects);
    }

    public static void main(String[] args) {
        HelloServiceCglib<HelloServiceImpl> methodInterceptor = new HelloServiceCglib<>();
        HelloServiceImpl helloService = methodInterceptor.newInstance(new HelloServiceImpl());
        helloService.sayHello("小快乐");
    }
}
