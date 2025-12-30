package com.codexdei.springboot.app.aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String person, String phrase) {

        String greeString = phrase + " " + person;
        System.out.println(greeString);
        return greeString;
    }

    @Override
    public String sayHelloExcepcion(String person, String phrase) {

        throw new RuntimeException("ERROR EXCEPTION");
    }


}
