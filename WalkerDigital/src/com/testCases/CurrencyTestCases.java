package com.testCases;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

import com.Currency.Constants.CurrencyEnum;

import currency.src.com.walkerdigital.toolkit.money.Currency;

/**
 * Test class containing unit testcases.
 * 
 * @author vipult
 *
 */
public class CurrencyTestCases {
	
	 @Test
	 public void testJunitSetup() {
	      String str= "Junit Working";
	      assertEquals("Junit Working",str);
	 }
	

	 /**
	  * This test case validate the Available currency present in ENUM.
	  */
	@Test
	public void testCurrencyAvailableInCurrencyEnum() {
		Currency lCurrency = Currency.getOrCreateByCurrencyCode("USD");	
		assertEquals(CurrencyEnum.USD.toString(),lCurrency.getDescription());
		assertEquals(lCurrency.getNumericCode(), "840");
		assertEquals(lCurrency.getJavaCurrency().getNumericCode(),840);
		assertEquals(lCurrency.getSymbol(Locale.US),"$");
		
		lCurrency = Currency.getOrCreateByCurrencyCode("HKD");
		assertEquals(CurrencyEnum.HKD.toString(),lCurrency.getDescription());
		assertEquals(lCurrency.getNumericCode(), "344");
		assertEquals(lCurrency.getJavaCurrency().getNumericCode(),344);
		assertEquals(lCurrency.getSymbol(Locale.US),"HKD");
	}
	
	/**
	 * This test case test Currency not available in ENUM.
	 */
	@Test
	public void testCurrencyNotAvailableInEnum() {
		//Test for diferent currency
				Currency lCurrency = Currency.getOrCreateByCurrencyCode("VEF");
				assertEquals(null,lCurrency.getDescription());
				assertEquals(lCurrency.getNumericCode(), "937");
				assertEquals(lCurrency.getJavaCurrency().getNumericCode(),937);
				assertEquals(lCurrency.getSymbol(Locale.US),"VEF");
				
				
				lCurrency = Currency.getOrCreateByCurrencyCode("CSD");
				assertEquals(null,lCurrency.getDescription());
				assertEquals(lCurrency.getNumericCode(), "891");
				assertEquals(lCurrency.getJavaCurrency().getNumericCode(),891);
				assertEquals(lCurrency.getSymbol(Locale.US),"CSD");
	}
	
	/**
	 * Testcase for testing null currency.
	 */
	@Test
	public void testNullCurrency() {
		//Test for diferent currency
				Currency lCurrency = Currency.getOrCreateByCurrencyCode(null);
				assertEquals(null,lCurrency);
	}
	
	/**
	 * Testcase for Non Existing currency code.
	 */
	@Test
	public void testNonExistingCurrencyCode() {
		//Test for diferent currency
		Currency lCurrency = Currency.getOrCreateByCurrencyCode("VE");
		assertEquals(null,lCurrency);	
	}
	
	/**
	 * Test case for validating currency by Abbreviation or Symbol. 
	 */
	@Test
	public void testgetBySymbol() {
		//Test for diferent currency
		Currency lCurrency = Currency.getByCurrencyAbbreviationOrSymbol("$");
		assertEquals(CurrencyEnum.USD.toString(),lCurrency.getDescription());
		assertEquals(lCurrency.getNumericCode(), "840");
		assertEquals(lCurrency.getJavaCurrency().getNumericCode(),840);
		assertEquals(lCurrency.getSymbol(Locale.US),"$");
		
		lCurrency = Currency.getByCurrencyAbbreviationOrSymbol("HK$");
		assertEquals(CurrencyEnum.HKD.toString(),lCurrency.getDescription());
		assertEquals(lCurrency.getNumericCode(), "344");
		assertEquals(lCurrency.getJavaCurrency().getNumericCode(),344);
		assertEquals(lCurrency.getSymbol(Locale.US),"HKD");
	}
	
	/**
	 * Testing for validing currency not non existing symbol.
	 */
	@Test
	public void testgetNonExistingSymbol() {
		//Test for diferent currency
		Currency lCurrency = Currency.getByCurrencyAbbreviationOrSymbol("$$");
		assertEquals(null,lCurrency);
	}

}
