package com.nttdata.test.framework.controller;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nttdata.test.framework.util.Util;

public class ControllerBase {
	protected  WebDriver driver;
	protected Util webDriverUtil;
	
	public ControllerBase (WebDriver driver){
		this.driver = driver;
		webDriverUtil = new Util(driver);
		
	}
	
	public void delayFor(int second){
		
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
