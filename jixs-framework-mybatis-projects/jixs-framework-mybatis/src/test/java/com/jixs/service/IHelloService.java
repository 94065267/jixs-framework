package com.jixs.service;

public interface IHelloService {
    default void hello(){
        System.out.println("Hello,world!");
    }
    default void sayHello(String name){
        System.out.println("Hello,world!");
    }
}
