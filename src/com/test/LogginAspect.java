package com.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	
	@Before("execution(public * draw*(..))")
	public void loggingAdvice(JoinPoint jointPoint){
		System.out.println(" --- Logging Method Called --- ");
		System.out.println(" ---  Target ---" + jointPoint.getTarget());
	}
	
	@Before("xyz()")
	public void loggingAdviceTwo(){
		System.out.println(" --- Logging Method Called Using Point Cut Expression --- ");
	}

	@Before("pqr()")
	public void loggingAdviceThree(){
		System.out.println(" --- Logging Method Called Using Point Cut Expression No. Three ... --- ");
	}

	@Before("p1()")
	public void loggingAdviceFour(){
		System.out.println(" --- Logging Method Called Using Point Cut Expression No. Four ... --- ");
	}
	
	@Pointcut("execution(public * draw*(..))")
	public void xyz(){}
	
	@Pointcut("within(com.test.Circle)")
	public void pqr(){}
	
	@Pointcut("args(int)")
	public void p1(){}
	
	@Around("execution(public * drawTest(..))")
	public void aroundAdivce(ProceedingJoinPoint jp) {
		System.out.println(" --- Around Advice Advice Start --- ");
		// can have logic that if the pre-condition is failed ... we can stop execution ...
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" --- Around Advice Advice End --- ");
	}
	
	@After("@annotation(com.test.Loggable)")
	public void test(){
		System.out.println(" --- Custom Annotaiion --- ");
	}
	
}
