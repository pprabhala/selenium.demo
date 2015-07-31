package com.nttdata.test.framework.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MortgageCalculatorModel extends ModelBase{

	public MortgageCalculatorModel(WebDriver driver) {
		super(driver);

	}

	private WebElement homeValueTextBox;	
	private WebElement loanAmountTextBox;	
	private WebElement intrstsRateTextBox;
	private WebElement loanTermTextBox;
	private WebElement startMonthDropDown;
	private WebElement startYearDropDown;
	private WebElement propertyTaxTextBox;
	private WebElement pmiTextBox;
	private WebElement calculateButton;
	private WebElement totalPaymentLable;
	
	public WebElement homeValueTextBox(){
		//	@FindBy (how = How.ID, using = "Email")
		//homeValueTextBox = driver.findElement(By.name("param[homevalue]"));
		homeValueTextBox = driver.findElement(By.xpath("//input[contains(@name,'homevalue')]"));
		//driver.findElement(By.xpath("//input[contains(@name,'homevalue')]"));
		return homeValueTextBox;
	}
	
	public WebElement loanAmountTextBox(){
		//@FindBy (how = How.ID, using = "Password")
		loanAmountTextBox = driver.findElement(By.id("loanamt"));
		
		return loanAmountTextBox;
	}
	
	public WebElement intrstsRateTextBox(){
		//@FindBy (how = How.XPATH, using = "//*[@id='Log In Button']")
		
		intrstsRateTextBox = driver.findElement(By.xpath("//*[@id='intrstsrate']"));
		//intrstsRateTextBox = driver.findElement(By.xpath("//input[@id='lst-ib']"));
		//""
		return intrstsRateTextBox;
	}
	
	public WebElement loanTermTextBox(){
		//	@FindBy (how = How.XPATH, using = "//*[@id='SubmitButton']")
		loanTermTextBox = driver.findElement(By.xpath("//*[@id='loanterm']"));
		
		return loanTermTextBox;
	}
	
	public WebElement startMonthComboBox(){
		//	@FindBy (how = How.XPATH, using = "//*[@id='Create New Account Button']")
		startMonthDropDown = driver.findElement(By.xpath("//select[contains(@name,'param[start_month]')]"));
		
		return startMonthDropDown;
	}
	
	public WebElement startYearComboBox(){
		//	@FindBy (how = How.XPATH, using = "//*[@id='Create New Account Button']")
		startYearDropDown = driver.findElement(By.xpath("//select[contains(@name,'param[start_year]')]"));
		//"//select[contains(@name,'param[start_year]')]"
		return startYearDropDown;
	}
	
	public WebElement propertyTaxTextBox(){
		//	@FindBy (how = How.XPATH, using = "//*[@id='Create New Account Button']")
		propertyTaxTextBox = driver.findElement(By.xpath("//*[@id='pptytax']"));
		
		return propertyTaxTextBox;
	}
	
	public WebElement pmiTextBox(){
		//	@FindBy (how = How.XPATH, using = "//*[@id='Create New Account Button']")
		//pmiTextBox = driver.findElement(By.xpath("//input[@id='pmi']"));
		pmiTextBox = driver.findElement(By.xpath("//input[contains(@name,'pmi')]"));
		//
		return pmiTextBox;
	}
	
	public WebElement calculateButton(){
		//	@FindBy (how = How.XPATH, using = "//*[@id='Create New Account Button']")
		calculateButton = driver.findElement(By.xpath("//input[@name='cal']"));
		
		return calculateButton;
	}
	
	public WebElement totalPaymentLable(){
		//	@FindBy (how = How.XPATH, using = "//*[@id='Create New Account Button']")
		totalPaymentLable = driver.findElement(By.xpath("//div[@class='repayment-block']/div[1]/div[2]/h3[1]"));
		
		return totalPaymentLable;
	}
}
