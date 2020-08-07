package com.jixs.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author: jixs
 * @date: 2020-07-29
 */
@Slf4j
public class ReflectService {
    public void sayHello(String name) {
        log.info("Hello,{}!", name);
    }

    @SneakyThrows
    public static void main(String[] args) {
        Object service = Class.forName(ReflectService.class.getName()).newInstance();
        Method method = service.getClass().getMethod("sayHello", String.class);
        method.invoke(service, "小快乐");

        log.info("method.getModifiers() = " + method.getModifiers());
        log.info("" + (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC));
        log.info("" + ((method.getModifiers() & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC));
        log.info("" + method.getDeclaringClass().isInterface());
    }
}
