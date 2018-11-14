package com.Tesuto.Utlities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class ITtestAnalyzer implements IRetryAnalyzer {
	
	int counter=0;
	int retrylimit=3;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(counter<retrylimit) {
			counter++;
			return true;
		}
		return false;
	}

}
