package com.mohit.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoveAopExpressions {
	
	@Pointcut("execution(* com.mohit.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.mohit.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.mohit.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDatoPackageWithoutGetterAndSetter() {}

}
