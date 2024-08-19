package com.example.SpringAOP.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.SpringAOP.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.example.SpringAOP.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n=====>>> Executing @Before advice on method");
    
        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // get the method signature

        // get arguments
        Object[] args = theJoinPoint.getArgs();

        // display arguments
        for (Object arg : args) {
            System.out.println("Argument: " + arg);

            if (arg instanceof Account) {
                 
                // downcast and print Account specific stuff
                Account account = (Account) arg;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }

        }

    }

    @AfterReturning(
        pointcut = "execution(* com.example.SpringAOP.dao.AccountDAO.findAccounts(..))",
        returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n=====>>> result is: " + result);

        // let's post-process the data

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        
        // loop through accounts
        for (Account account : result) {
            
            // get uppercase version of name
            String upperName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(upperName);
        }

    }

    @AfterThrowing(
        pointcut = "execution(* com.example.SpringAOP.dao.AccountDAO.findAccounts(..))",
        throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);

    }

    @After("execution(* com.example.SpringAOP.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);

    }

    // HandleException
    // @Around("execution(* com.example.SpringAOP.dao.service.TrafficFortuneService.getFortune(..))")
    // public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

    //     // print out which method we are advising on
    //     String method = theProceedingJoinPoint.getSignature().toShortString();
    //     System.out.println("\n=====>>> Executing @Around on method: " + method);

    //     // get begin timestamp
    //     long begin = System.currentTimeMillis();

    //     // execute the method
    //     Object result = null;

    //     try {
    //         result = theProceedingJoinPoint.proceed();
    //     } catch (Exception e) {
    //         // log the exception
    //         System.out.println("\n=====>>> The exception is: " + e);

    //         // rethrow exception
    //         return result;
    //     }

    //     // get end timestamp
    //     long end = System.currentTimeMillis();

    //     // compute duration and display it
    //     long duration = end - begin;
    //     System.out.println("\n=====>>> Duration: " + duration / 1000.0 + " seconds");

    //     return result;

    // }

    // RethrowException
    @Around("execution(* com.example.SpringAOP.dao.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            // log the exception
            System.out.println("\n=====>>> The exception is: " + e);

            // rethrow exception
            throw e;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n=====>>> Duration: " + duration / 1000.0 + " seconds");

        return result;

    }

}
