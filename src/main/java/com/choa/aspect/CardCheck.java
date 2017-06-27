package com.choa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CardCheck {
	
	@Before("execution(* com.choa.aspect..Trip.*(..))")
	public void reservation(){
		
		System.out.println("예약 완료");
		System.out.println("=============");
	}
	
	@Around("execution(* com.choa.aspect..Transport.*(..))")
	public Object check(ProceedingJoinPoint join){
		System.out.println("Card Check In");
		
		Object obj = null;
		try {
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Card Check Out");
		
		return obj;
	}

}
