package com.Tesuto.Utlities;

import java.awt.ItemSelectable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.ExtentReport.report.ExtentReportListner;
import com.Tesuto.TestBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listener extends TestBase implements ITestListener,IAnnotationTransformer{
	
	
	//Extent Report Declarations
    private static ExtentReports extent = ExtentReportListner.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    private ExtentTest ParentextentTest;
    private ExtentTest ChildExtentTest;
 
    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
        ParentextentTest = extent.createTest(context.getName());
        
        log=Logger.getLogger(context.getName());
        PropertyConfigurator.configure("/Users/prakumak/git/NaveenPOMProject/Naveen_HybridPOM/src/main/java/com/Tesuto/Config/log4j.properties");

    }
 
    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }
 
    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ChildExtentTest = ParentextentTest.createNode(result.getName());
        test.set(ChildExtentTest);
    }
 
    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }
 
    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
       // test.get().fail(result.getThrowable());
    }
 
    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
       // test.get().skip(result.getThrowable());
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

	

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		
		annotation.setRetryAnalyzer(ITtestAnalyzer.class);
	}
}

