package com.codexdei.springboot.app.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* com.codexdei.springboot.app.aop.services.GreetingService.*(..))")
    public void greetingFooLoggerPointcut() {
    }
    
    @Pointcut("execution(* com.codexdei.springboot.app.aop.services.GreetingService.*(..))")
    public void greetingLoggerPointcut(){}

}
