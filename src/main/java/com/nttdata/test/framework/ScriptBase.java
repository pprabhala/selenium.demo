package com.nttdata.test.framework;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.nttdata.test.framework.controller.ApplicationController;


public class ScriptBase implements IResourceConstants{

	private static Logger log = Logger.getLogger(ScriptBase.class.getName());

	protected WebDriver driver = null;
	private ApplicationController applicationController = null;
	//private String  tempURL= "";



	@Parameters ({"browser"} )
	
	@BeforeClass
	public void beforeClass(@Optional("ff") String browser) throws MalformedURLException{
		//PropertyConfigurator.configure("log4j.properties");
				log.info(String.format("startApplication()"));

				//FirefoxProfile profile  = new FirefoxProfile();
				//profile.setPreference("browser.cache.disk.enable",false);
				//driver = new FirefoxDriver(profile);

				if(browser.contentEquals("ie")){
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					File driverFile = new  File (System.getProperty("user.dir")+"/src/main/resources/tools/Driver/IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver",driverFile.getAbsolutePath());
					driver = new InternetExplorerDriver(capabilities);

				}else if(browser.contentEquals("ff")){
					FirefoxProfile profile  = new FirefoxProfile();
					profile.setPreference("browser.cache.disk.enable",false);
					driver = new FirefoxDriver(profile);
				}else if(browser.contentEquals("chrome")){

				}else if(browser.contentEquals("opera")){

				}else if(browser.contentEquals("safari")){

					driver = new SafariDriver();

				}

				

						
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);			
				driver.manage().window().maximize();
				//driver = new InternetExplorerDriver();
				//driver = new FirefoxDriver();



		
	}
	
	@BeforeMethod	

	public void beforeMethod() {

		log.info(String.format("URL : " + APP_URL));	
		driver.navigate().to(APP_URL);
		
		
		
		
		
		
		
		/*//PropertyConfigurator.configure("log4j.properties");
		log.info(String.format("startApplication()"));

		//FirefoxProfile profile  = new FirefoxProfile();
		//profile.setPreference("browser.cache.disk.enable",false);
		//driver = new FirefoxDriver(profile);

		if(browser.contentEquals("ie")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			File driverFile = new  File (System.getProperty("user.dir")+"/src/main/resources/tools/Driver/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver",driverFile.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);

		}else if(browser.contentEquals("ff")){
			FirefoxProfile profile  = new FirefoxProfile();
			profile.setPreference("browser.cache.disk.enable",false);
			driver = new FirefoxDriver(profile);
		}else if(browser.contentEquals("chrome")){

		}else if(browser.contentEquals("opera")){

		}else if(browser.contentEquals("safari")){

			driver = new SafariDriver();

		}

		

		log.info(String.format("URL : " + APP_URL));			
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to(new URL(APP_URL));
		driver.manage().window().maximize();
		//driver = new InternetExplorerDriver();
		//driver = new FirefoxDriver();


*/

	}

	public void getScreenShot(String fileName)
	{
			
		
		try {
			File scnFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			DateFormat dateFormat = new SimpleDateFormat("yyyMMdd_hhmmss_a");
			
			Date date = new Date();
			FileUtils.copyFile(scnFile,new File(System.getProperty("user.dir")+ "/reports/screenshots/" + fileName + "_" + dateFormat.format(date) +".png"),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@AfterClass
	public void afterClass(){
		driver.close();
		driver.quit();
		applicationController = null;
		log.info(String.format("CloseApplication()"));
		
	}
	
	
	@AfterMethod
	public void afterMethod(){


	
	
		//
	}
/*	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws Exception {
	    if (!result.isSuccess())
	        takeScreenShoot(threadDriver, result.getMethod());
	 
	    // Quit environment.
	    driver.close();
	    driver.quit();
	}
	
	public void takeScreenShoot(ThreadLocal threadDriver, ITestNGMethod testMethod) throws Exception {
	    WebDriver augmentedDriver = new Augmenter().augment(threadDriver.get());
	    File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
	    String nameScreenshot = testMethod.getMethodName();
	    String path = getPath(nameScreenshot);
	    FileUtils.copyFile(screenshot, new File(path));
	    Reporter.log("<a href="file://&quot;" target="_blank">" + this.getFileName(nameScreenshot) + "</a>");
	}
	 
	private String getFileName(String nameTest) throws IOException {
	    DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
	    Date date = new Date();
	    return dateFormat.format(date) + "_" + nameTest + ".png";
	}
	 
	private String getPath(String nameTest) throws IOException {
	    File directory = new File(".");
	    String newFileNamePath = directory.getCanonicalPath() + "/target/surefire-reports/screenShots/" + getFileName(nameTest);
	    return newFileNamePath;
	}*/

	public ApplicationController mortgagecalculator(){
		if (applicationController == null){
			applicationController = new ApplicationController(driver);
		}

		return applicationController;
	}
}
