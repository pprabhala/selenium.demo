package com.nttdata.test.framework.controller;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.nttdata.test.framework.IResourceConstants;

public class ApplicationController extends ControllerBase implements IResourceConstants{

	private static Logger log = Logger.getLogger(ApplicationController.class.getName());
	
	private MortgageCalculatorController mortgageCalculatorController = null;
	
	public ApplicationController(WebDriver driver){
		super(driver);
		/*this.driver = driver;
		PageFactory.initElements(driver, this);*/
		//applicatoinModel = new ApplicatoinModel(driver);
	}
	

	//@BeforeTest
	//public void startApplication(String app){
	public void startApplication(){
		//PropertyConfigurator.configure("log4j.Properties");

		log.info(String.format("startApplication()"));

		String  tempURL= "";
		try {
			/*if (app.contentEquals("EXTERNAL_PORTAL")){
				tempURL = APP_URL;			
			}else if (app.contentEquals("INTERNAL_PORTAL")){
				//tempURL = APP_URL_ADJUDICATOR;	
			}else {
				tempURL = app;	
			}*/
			tempURL = APP_URL;		
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.navigate().to(new URL(tempURL));
			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			


		/*	//if applicatoinModel.continueToThisWebSite.isDisplayed()
			if (applicatoinModel.continueToThisWebSite().isDisplayed()){				
				applicatoinModel.continueToThisWebSite().click();
			}*/

		}catch (Exception ex) {
			log.error(ex.toString());
			//System.out.println(ex.toString());
		}finally{

		}

	}
	
	public MortgageCalculatorController homePage(){
		if (mortgageCalculatorController == null){
			mortgageCalculatorController = new MortgageCalculatorController(driver);
		}

		return mortgageCalculatorController;
	}
}
