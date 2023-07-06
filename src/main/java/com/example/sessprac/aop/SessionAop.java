package com.example.sessprac.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class SessionAop {
    @Pointcut("execution(* com.example.sessprac..*Controller.*(..))")
    private void allController(){} // pointcut signature

    @Around("allController() && args(.., session)")
    public Object verifySession(ProceedingJoinPoint joinPoint, HttpSession session) throws Throwable{

        Object userId = session.getAttribute("session");
        if(userId == null){
            System.out.println("END");
            return 0;
        }else{
            return joinPoint.proceed();
        }
    }

}
