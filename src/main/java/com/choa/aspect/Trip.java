package com.choa.aspect;

import org.springframework.stereotype.Component;

@Component
public class Trip {
	
	public void go(){
		System.out.println("공항으로 출발~");
		System.out.println("================");
	}

}
