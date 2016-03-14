package currency.src;

import currency.src.com.walkerdigital.toolkit.money.Currency;

/******************************
 * INSTRUCTIONS
 *
 * Steps:
 * 1. Add Unit tests for all public methods.
 * 2. All methods must have Javadoc comments.
 * 3. Fix the bug. Run the main method and you will see HKD and MYR are the same. This is not correct.
 * 4. New functionality: create and implement a public interface for adding new currencies at runtime
 * 5. Refactor the Currency class and explain why your refactors are improvements.
 * 
 * When the updates have been completed, zip up the project and email it back.
 * Use of 3rd-party software (e.g. frameworks like Maven) is encouraged where applicable, however please point out all instances where the code you used was not your own.
 * Provide information on how long you worked on it and explain your changes.
 ******************************/

/**
 * This is the main class to run Currency App.
 * 
 * @author vipult
 *
 */
public class Main {

    public static void main(String[] args) {
    	
    	boolean currenciesAreSame = false;
        Currency currencyUSD = Currency.getOrCreateByCurrencyCode("USD");
        Currency currencyHKD = Currency.getOrCreateByCurrencyCode("HKD");
        Currency currencyMYR = Currency.getOrCreateByCurrencyCode("MYR");
        
        if(currencyUSD == null || currencyHKD == null || currencyMYR == null)
        {
        	System.out.println("Either of the currecny object is NULL");
        }
        
        else
        {
        	currenciesAreSame = currencyUSD.equals(currencyHKD);
            if (currenciesAreSame) {
                System.out.println("USD and HKD currencies are the same.");
            }
            else {
                System.out.println("USD and HKD currencies are different.");
            }

            currenciesAreSame = currencyUSD.equals(currencyMYR);
            if (currenciesAreSame) {
                System.out.println("USD and MYR currencies are the same.");
            }
            else {
                System.out.println("USD and MYR currencies are different.");
            }

            currenciesAreSame = currencyHKD.equals(currencyMYR);
            if (currenciesAreSame) {
                System.out.println("HKD and MYR currencies are the same.");
            }
            else {
                System.out.println("HKD and MYR currencies are different.");
            }
	
        }
                        
        //For new Currency
        Currency testObj1 = Currency.getOrCreateByCurrencyCode("LTL");
        Currency testObj2 = Currency.getOrCreateByCurrencyCode("LTL");
        
        if(testObj1 == null || testObj2 == null)
        {
        System.out.println("Currency Object returned is NULL. Please check currency code.");	
        }
        else
        {
        	currenciesAreSame = testObj1.equals(testObj2);
            if (currenciesAreSame) {
                System.out.println(testObj1.getCurrencyCode()+" and "+testObj2.getCurrencyCode()+" "
                		+ "currencies are the same.");
            }
            else {
                System.out.println("HKD and MYR currencies are different.");
            }	
        }
    }
}
