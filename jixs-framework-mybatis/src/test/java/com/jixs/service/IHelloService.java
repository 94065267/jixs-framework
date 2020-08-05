package com.jixs.service;

public interface IHelloService {
    default void hello(){
        System.out.println("Hello,world!");
    }
    void sayHello(String name);
}
