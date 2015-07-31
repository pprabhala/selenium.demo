package com.nttdata.test.framework.controller;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.nttdata.test.framework.model.MortgageCalculatorModel;

public class MortgageCalculatorController extends ControllerBase{

	private static Logger log = Logger.getLogger(MortgageCalculatorController.class.getName());

	private MortgageCalculatorModel mortgageCalculatorModel = null;
	
	public MortgageCalculatorController(WebDriver driver){
		super(driver);
		
		mortgageCalculatorModel = new MortgageCalculatorModel(driver);
		delayFor(2);
	}
	
	
	
	
	
	/**
	 *  Method Name   : <b>enterHomeValue</b>
	 * 	<br>Description : This method will enter Home value to home value text box.</br>
	 * 
	 *  @author Hasan Ora
	 *  @param homeValue the Home Value
	 *  @return
	 *  @since   2015/07/27
	 */
	public void enterHomeValue(String homeValue){
		
		log.info(String.format("enterHomeValue(%s)",homeValue));
		

		try{
			delayFor(1);
			webDriverUtil.enterText(mortgageCalculatorModel.homeValueTextBox(), homeValue);
			//Assert.assertNotNull(mortgageCalculatorModel.homeValueTextBox());
			//mortgageCalculatorModel.homeValueTextBox().sendKeys(homeValue);
			
		}
		finally 
		{
		

		}
	}
	
	/**
	 *  Method Name   : <b>enterLoanAmout</b>
	 * 	<br>Description : This method will enter Loan Amount to Loan amount text box.</br>
	 * 
	 *  @author Hasan Ora
	 *  @param loanAmount the Loan Amount
	 *  @return
	 *  @since   2015/07/27
	 */
	public void enterLoanAmout(String loanAmount){
		
		log.info(String.format("enterLoanAmout(%s)",loanAmount));
		

		try{
			webDriverUtil.enterText(mortgageCalculatorModel.loanAmountTextBox(), loanAmount);
			
			
		}
		finally 
		{
		

		}
	}
	
	/**
	 *  Method Name   : <b>enterInterestRate</b>
	 * 	<br>Description : This method will enter Interest rate to Interest rate text box.</br>
	 * 
	 *  @author Hasan Ora
	 *  @param interestRate the Interest rate
	 *  @return
	 *  @since   2015/07/27
	 */
	public void enterInterestRate(String interestRate){
		
		log.info(String.format("enterInterestRate(%s)",interestRate));
		

		try{
			webDriverUtil.enterText(mortgageCalculatorModel.intrstsRateTextBox(), interestRate);
			
			
		}
		finally 
		{
		

		}
	}
	
	/**
	 *  Method Name   : <b>enterLoanterm</b>
	 * 	<br>Description : This method will enter Loan term to Loan term tex tbox.</br>
	 * 
	 *  @author Hasan Ora
	 *  @param loanterm the Loan term
	 *  @return
	 *  @since   2015/07/27
	 */
	public void enterLoanterm(String loanterm){
		
		log.info(String.format("enterLoanterm(%s)",loanterm));
		

		try{
			webDriverUtil.enterText(mortgageCalculatorModel.loanTermTextBox(), loanterm);
			
			
		}
		finally 
		{
		

		}
	}
	
	
	/**
	 *  Method Name   : <b>selectStartDateMonth</b>
	 * 	<br>Description : This method will select Start Date Month from combo box.</br>
	 * 
	 *  @author Hasan Ora
	 *  @param startDateMonth the Start Date Month
	 *  @return
	 *  @since  2015/07/27
	 */
	public void selectStartDateMonth(String startDateMonth){

		log.info(String.format("selectStartDateMonth(%s)", startDateMonth));


		try{

			
			webDriverUtil.selectElement(mortgageCalculatorModel.startMonthComboBox(),startDateMonth);
		}
		finally {

		}

	}
	
	/**
	 *  Method Name   : <b>selectStartDateYear</b>
	 * 	<br>Description : This method will select Start Date Month from combo box.</br>
	 * 
	 *  @author Hasan Ora
	 *  @param startDateYear the Start Date Month
	 *  @return
	 *  @since  2015/07/27
	 */
	public void selectStartDateYear(String startDateYear){

		log.info(String.format("selectStartDateYear(%s)", startDateYear));


		try{

			
			webDriverUtil.selectElement(mortgageCalculatorModel.startYearComboBox(),startDateYear);
		}
		finally {

		}

	}
	
	/**
	 *  Method Name   : <b>enterPropertytax</b>
	 * 	<br>Description : This method will enter Property tax to Property tax text box.</br>
	 * 
	 *  @author Hasan Ora
	 *  @param propertyTax the Property tax
	 *  @return
	 *  @since   2015/07/27
	 */
	public void enterPropertytax(String propertyTax){
		
		log.info(String.format("enterPropertytax(%s)",propertyTax));
		

		try{
			webDriverUtil.enterText(mortgageCalculatorModel.propertyTaxTextBox(), propertyTax);
			
			
		}
		finally 
		{
		

		}
	}
	
	
	/**
	 *  Method Name   : <b>enterPMI</b>
	 * 	<br>Description : This method will enter PMI to PMI text box.</br>
	 * 
	 *  @author Hasan Ora
	 *  @param pmi the PMI
	 *  @return
	 *  @since   2015/07/27
	 */
	public void enterPMI(String pmi){
		
		log.info(String.format("enterPMI(%s)",pmi));
		

		try{
			webDriverUtil.enterText(mortgageCalculatorModel.pmiTextBox(), pmi);
			
			
		}
		finally 
		{
		

		}
	}
	
	/**
	 *  Method Name   : <b>calculateButton</b>
	 * 	<br>Description : This method will click on Calculate button.</br>
	 * 
	 *  @author Hasan Ora
	 *  @return
	 *  @since  2015/07/27
	 */
	public void calculateButton(){
		
		log.info(String.format("calculateButton()"));
		
		try{
			Assert.assertNotNull(mortgageCalculatorModel.calculateButton());
			mortgageCalculatorModel.calculateButton().click();
			delayFor(1);
						
		}
		finally{
			
		}
	}
	

	private void actionButton(String action){
		
		if (action.contentEquals("CALCULATE")){
			calculateButton();
		}
	}
	
	/**
	 *  Method Name   : <b>createProvideEmailAndAccountType</b>
	 * 	<br>Description : This method will create a elis portal account.</br>
	 * 
	 *  @author Hasan Ora
	 *  @param selectItem Select Item
	 *  @param emailAddress Email Address
	 *  @return
	 *  @since  2013/10/29
	 */
	public void mortgageCalculator(String homeValue, String loanAmount,String interestRate, String loanterm,
							       String startDateMonth, String startDateYear, String propertyTax, String pmi, String action){
		
		log.info(String.format("createProvideEmailAndAccountType(%s,%s,%s,%s,%s,%s,%s,%s)",homeValue,loanAmount,interestRate,
																						loanterm,startDateMonth,startDateYear,propertyTax,pmi,action));
		
		if (!homeValue.contentEquals("!")){
			enterHomeValue(homeValue);
		}
		
		if (!loanAmount.contentEquals("!")){
			enterLoanAmout(loanAmount);
		}
		
		
		if (!interestRate.contentEquals("!")){
			enterInterestRate(interestRate);
		}
		
		
		if (!loanterm.contentEquals("!")){
			enterLoanterm(loanterm);
		}
		
		if (!startDateMonth.contentEquals("!")){
			selectStartDateMonth(startDateMonth);
		}
		
		if (!startDateYear.contentEquals("!")){
			selectStartDateYear(startDateYear);
		}
		
		if (!propertyTax.contentEquals("!")){
			enterPropertytax(propertyTax);
		}
		
		if (!pmi.contentEquals("!")){
			enterPMI(pmi);
		}
		
		if (!action.contentEquals("!")){
			actionButton(action);
		}
		
	}
	
	//************ Verification ********************************
	/**
	 * 	Method Name   : <b>verifymortgagecalculatorPageExist</b>
	 * 	<br>Description : This method will verify if Mortgage Calculator home  Page exist.</br>
	 * 
	 *  @author Hasan Ora
	 *  @return
	 *  @since  2014/07/27
	 */
	public void verifymortgagecalculatorPageExist(){

		log.info(String.format("verifymortgagecalculatorPageExist()"));
		
		String pageName = "Mortgage Calculator Home";
		String isExist = "";

		if(mortgageCalculatorModel.homeValueTextBox().isDisplayed()){		
			
			isExist = "Exist.";
	
		}else{
			isExist = "Does Not Exist.";
		}
		
		Assert.assertEquals(true, mortgageCalculatorModel.homeValueTextBox().isDisplayed());
		log.info(pageName + " Page " + isExist);
	}

	
	/**
	 * 	Method Name   : <b>verifymortgagecalculatorPageExist</b>
	 * 	<br>Description : This method will verify if Mortgage Calculator home  Page exist.</br>
	 * 
	 *  @author Hasan Ora
	 *  @return
	 *  @since  2014/07/27
	 */
	public void assertTotalPaymnet(String expectedPayment){

		log.info(String.format("assertTotalPaymnet(%s)", expectedPayment));
		
	
		String tempText = mortgageCalculatorModel.totalPaymentLable().getText();
		log.info("Expected Text :" + tempText);
		Assert.assertEquals(true, mortgageCalculatorModel.totalPaymentLable().isDisplayed());
		//Assert.assertEquals(mortgageCalculatorModel.totalPaymentLable(), expectedPayment);
		Assert.assertEquals(expectedPayment,tempText);
		//log.info(pageName + " Page " + isExist);
	}
	
}
