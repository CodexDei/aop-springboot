package com.codexdei.springboot.app.aop.services;


public interface GreetingService {

    String sayHello(String person, String phrase);
    String sayHelloExcepcion(String person, String phrase);
}
