package com.codexdei.springboot.app.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.codexdei.springboot.app.aop.services.GreetingService.*(..))")
    private void greetingLoggerPointcut(){}

    @Before("greetingLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("BEFORE: " + method + " with the args: " + args);
    }

    @After("greetingLoggerPointcut()")
    public void loggerAfter(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AFTER: " + method + " with the args: " + args);
    }

    @AfterReturning("greetingLoggerPointcut()")
    public void loggerAfterReturning(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AFTER RETURNING: " + method + " with the args: " + args);
    }

    @AfterThrowing("greetingLoggerPointcut()")
    public void loggerAfterThrowing(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AFTER THROWING: " + method + " with the args: " + args);
    }

    @Around("greetingLoggerPointcut()")
    public Object loggerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().getName();
        String args = Arrays.toString(proceedingJoinPoint.getArgs());

        Object result = null;

        try {
            
            logger.info("METHOD: " + method + " with the args: " + args);
            result = proceedingJoinPoint.proceed();
            logger.info("METHOD:" + method + "with the result" + result);

        } catch (Throwable e) {

            logger.error("ERROR!! in the call to the method:" + method + "()");
            throw e;
        }

        return result;
    }
}
