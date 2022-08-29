package com.chandan.assignment.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import com.chandan.assignment.basepage.BasePage;

public class Listener extends BasePage implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Test started "+result.getMethod().getMethodName());

	}
@AfterMethod(alwaysRun=true)
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test is success "+result.getMethod().getMethodName());
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateformat=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		String methodName=result.getName();
		if(result.isSuccess()) {
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String reportingDir=(new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/chandan/assignment/");
			File destination=new File((String)reportingDir+"/passedScreens/"+methodName+dateformat.format(cal.getTime())+".png");
			try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test is Failed "+result.getMethod().getMethodName());
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateformat=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		String methodName=result.getName();
		if(!result.isSuccess()) {
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String reportingDir=(new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/chandan/assignment/");
			File destination=new File((String)reportingDir+"/failedScreens/"+methodName+dateformat.format(cal.getTime())+".png");
			try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}


	

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test is skipeed "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}


}
