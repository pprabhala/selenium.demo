package com.nttdata.test.framework.util;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Util {
	protected WebDriver driver = null;
	
	public Util (WebDriver driver){
		this.driver = driver;
		
	}
	
	public void selectElement(WebElement element, String itme){
		
		Assert.assertNotNull(element);
		
		Select elementComboBox = new  Select(element);
		
		List <WebElement> list = elementComboBox.getOptions();
		for (WebElement e : list){
			if(e.getText().contentEquals(itme)){
				e.click();
				break;
			}
		}
	}
	public void enterText(WebElement element, String value){
		
		
		Assert.assertNotNull(element);
		
		element.clear();
		element.sendKeys(value);
	}
}
