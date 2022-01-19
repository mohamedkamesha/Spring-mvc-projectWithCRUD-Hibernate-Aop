package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	Logger logger = Logger.getLogger(getClass().getName());
	
	//setup poinCut 
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..) )")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..) )")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..) )")
	private void forServicePackage() {}
	
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage() ")
	private void forAppFlow() {}
	

	//before
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		//display method
		String method = joinPoint.getSignature().toString();
		logger.info("=====>>>>@before method : "+method);
		
		//display Arguments
		Object [] objects = joinPoint.getArgs();
		for(Object object : objects )
			logger.info("argument===> "+object);
	}
	
	
	//after returning
	@AfterReturning(pointcut = "forAppFlow()",returning = "result")
	public void afterReturning (JoinPoint joinPoint,Object result) {
		//display method
		String method = joinPoint.getSignature().toString();
		logger.info("=====>>>>@@AfterReturning method : "+method);
		
		//display returning result
		logger.info("====>> "+result);
		
	}
	
}
