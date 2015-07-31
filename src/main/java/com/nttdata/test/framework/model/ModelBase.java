package com.nttdata.test.framework.model;

import org.openqa.selenium.WebDriver;

public class ModelBase {
	protected WebDriver driver;
	
	public ModelBase (WebDriver driver){
	
		this.driver = driver;
		
	}
}
