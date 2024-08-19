package com.example.SpringAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.example.SpringAOP.dao.*.*(..))")
    public void forDaoPackage() {}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.example.SpringAOP.dao.*.get*(..))")
    public void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.example.SpringAOP.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package ... exclude getter/setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
