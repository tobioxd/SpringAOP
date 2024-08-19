package com.example.SpringAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@Aspect
@Component
@Order(3)
public class MyApiAnalystAspect {

    @Before("com.example.SpringAOP.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n====>>> Performing API analytics");
    }

}
