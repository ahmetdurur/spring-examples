package com.haydikodlayalim.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Before("execution(* com.haydikodlayalim.service.MessageService.mesajVer(..))")
    public void mesajVerMetodundanOnce(JoinPoint joinPoint){
        System.out.println("Mesaj Ver metodundan once parametre yakalandi param: "+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.haydikodlayalim.service.*.*(..))")
    public void mesajVerMetodundanSonra(JoinPoint joinPoint){
        System.out.println("Mesaj Ver metodundan sonra parametre yakalandi param: "+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
