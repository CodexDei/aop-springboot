package com.codexdei.springboot.app.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//order como su nombre lo indica es para ordenar el orden en que se ejecutaran los
//aspects, en este caso como tiene el order(1) los before seran los primeros en ejecutarse PERO
//los after seran los ultimos en ejecutarse, befor primeros en ejecutarse after ultimos en ejecutarse
@Order(1)
@Component
@Aspect
public class GreetingFooAspect {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.codexdei.springboot.app.aop.services.GreetingService.*(..))")
    private void greetingFooLoggerPointcut(){}

    @Before("greetingFooLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("BEFORE_FOO: " + method + " invoked with the parameters: " + args);
    }

    @After("greetingFooLoggerPointcut()")
    public void loggerAfter(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AFTER_FOO: " + method + "invoked with the parameters: " + args);
    }

}
