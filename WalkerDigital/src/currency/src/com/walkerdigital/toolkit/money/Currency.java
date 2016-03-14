package currency.src.com.walkerdigital.toolkit.money;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.Currency.Constants.AppConstants;
import com.Currency.Constants.CurrencyEnum;

/**
 * Main Class providing Currency implementation.
 * 
 * @author vipult
 *
 */
public class Currency implements Serializable
{
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 8228779577409316939L;
	
	/**
	 * Java Util currency object.
	 */
    private final java.util.Currency javaCurrency;
    
    /**
     * Numneric Code of the currency
     */
	private final String numericCode;
	
	/**
	 * Currency Symbol use to override the currency code in java.util.Currency
	 */
	private final String currencySymbolOverride;  
	
	/**
	 * Currency Description
	 */
    private final String description;
    
    /**
     * HashCode of this class
     */
	private final int hashCode;

	/**
	 * the number of sub-units of the currency (e.g. US dollars have 100 sub-units, or pennies)
	 */
	private final int scale;
	
	/**
	 * Map containing objects of this currency class.
	 * 
	 * Key is Currency code.
	 * Value is Object.
	 * 
	 */
	static Map<String, Currency> currencyMap = new HashMap<>(); 
	
	/**
	 * Static block to load available currency codes.
	 */
	static
	{
		for(CurrencyEnum currency : CurrencyEnum.values())
		{
			if(currency.equals(CurrencyEnum.USD))
			{
				currencyMap.put(AppConstants.CURRENCY_CODE_USD, 
						getOrCreateCurrencyObject(currency.name(), null, null));	
			}
			
			else if(currency.equals(CurrencyEnum.HKD))
			{
				currencyMap.put(AppConstants.CURRENCY_CODE_HKD, 
						getOrCreateCurrencyObject(currency.name(), null, null));	
			}
			
			else if(currency.equals(CurrencyEnum.MYR))
			{
				currencyMap.put(AppConstants.CURRENCY_CODE_MYR, 
						getOrCreateCurrencyObject(currency.name(), null, null));	
			}
		}
	}
    
    /**
	 * Constructor to override the currency code in java.util.Currency
	 * 
	 * @param aInCurrency
	 * @param aInNumericCode
	 * @param aInScale
	 * @param aInDescription
	 * @param aInCurrencySymbolOverride
	 */
	private Currency(java.util.Currency aInCurrency, String aInNumericCode, int aInScale, String aInDescription, 
			String aInCurrencySymbolOverride)
	{
		javaCurrency = aInCurrency;
		numericCode = aInNumericCode;
		description = aInDescription;
		hashCode = Integer.parseInt(numericCode);
		scale = aInScale;
		//Assign symbol based on currency Symbol.
		if(aInCurrencySymbolOverride!=null)
		{
			currencySymbolOverride = aInCurrencySymbolOverride;	
		}
		else
		{
			currencySymbolOverride = javaCurrency.getSymbol();
		}	
	}
    
    /**
     * This method return the currency object base of Currency Code
     * 
     * @param 			aInCurrencyCode
     * @return			Currency Object 
     */
    private static Currency getOrCreateCurrencyObject(String aInCurrencyCode, String aInCurrDes, String aInCurrSymbol)
    {
    	Currency lCurrencyObject = null;
    	
    	if(aInCurrencyCode == null)
    	{
    		return null;
    	}
    	
    	switch(aInCurrencyCode)
    	{
    	
    	case "USD" :
    		lCurrencyObject = new Currency(java.util.Currency.getInstance(AppConstants.CURRENCY_CODE_USD), 
    				Currency.getCurrencyNumericCode(AppConstants.CURRENCY_CODE_USD), 100, 
    				CurrencyEnum.USD.toString(),AppConstants.CURRENCY_SYMBOL_USD);
    		return lCurrencyObject;
    	
    	case "HKD" :
    		lCurrencyObject = new Currency(java.util.Currency.getInstance(AppConstants.CURRENCY_CODE_HKD), 
    				Currency.getCurrencyNumericCode(AppConstants.CURRENCY_CODE_HKD), 100, 
    				CurrencyEnum.HKD.toString(), AppConstants.CURRENCY_SYMBOL_HKD);
    		return lCurrencyObject;
			
        case "MYR" :
        	lCurrencyObject = new Currency(java.util.Currency.getInstance(AppConstants.CURRENCY_CODE_MYR), 
        			Currency.getCurrencyNumericCode(AppConstants.CURRENCY_CODE_MYR), 100, 
        			CurrencyEnum.MYR.toString(), AppConstants.CURRENCY_SYMBOL_RM);
        	return lCurrencyObject;
        	
        default:
        	//if None of the currency code found create the new object.
        	try
        	{
        		lCurrencyObject = new Currency(java.util.Currency.getInstance(aInCurrencyCode), 
            			Currency.getCurrencyNumericCode(aInCurrencyCode), 100, 
            			null, null);
            	currencyMap.put(aInCurrencyCode, lCurrencyObject);
            	return lCurrencyObject;	
        	}
        	catch(Exception e)
        	{
        	System.out.println("Exception occured for currency code: "+aInCurrencyCode+". "
        			+ "Exception message: "+e.toString()+".");
        	}	
    	}	
    	return null;
    }

    /**
	 * Get a {@link Currency} by its ISO 4217 code
	 * @param aInCurrencyCode
	 * @return the currency for the given code, or null if the code is not supported
	 */
	public static Currency getOrCreateByCurrencyCode(String aInCurrencyCode)
	{
		if (AppConstants.CURRENCY_CODE_USD.equalsIgnoreCase(aInCurrencyCode))
		{
			return currencyMap.get(AppConstants.CURRENCY_CODE_USD);
		}

		else if (AppConstants.CURRENCY_CODE_HKD.equalsIgnoreCase(aInCurrencyCode))
		{
			return currencyMap.get(AppConstants.CURRENCY_CODE_HKD);
		}

		else if (AppConstants.CURRENCY_CODE_MYR.equalsIgnoreCase(aInCurrencyCode))
		{
			return currencyMap.get(AppConstants.CURRENCY_CODE_MYR);
		}
		
		else
		{
			Currency lCurrency = getOrCreateCurrencyObject(aInCurrencyCode, null, null);
			currencyMap.put(aInCurrencyCode, lCurrency);
			return lCurrency;
		}
	}

	/**
	 * Get Currency based on Abbreviation or Symbol
	 * 
	 * @param pCurrencyAbbreviationOrSymbol
	 * @return
	 */
    public static Currency getByCurrencyAbbreviationOrSymbol(String pCurrencyAbbreviationOrSymbol)
    {
        if (AppConstants.CURRENCY_SYMBOL_USD.equalsIgnoreCase(pCurrencyAbbreviationOrSymbol))
        {
            return currencyMap.get(AppConstants.CURRENCY_CODE_USD);
        }

        if (AppConstants.CURRENCY_SYMBOL_HKD.equalsIgnoreCase(pCurrencyAbbreviationOrSymbol))
        {
            return currencyMap.get(AppConstants.CURRENCY_CODE_HKD);
        }

        if (AppConstants.CURRENCY_SYMBOL_RM.equalsIgnoreCase(pCurrencyAbbreviationOrSymbol))
        {
            return currencyMap.get(AppConstants.CURRENCY_CODE_MYR);
        }

        return null;
    }

	/**
	 * Is the given currency code supported in the system?
	 * 
	 * @param pCurrencyCode
	 * @return
	 */
	public static boolean isSupportedCurrencyCode(String pCurrencyCode)
	{
		return getOrCreateByCurrencyCode(pCurrencyCode) != null;
	}

	/**
	 * This method will return Currency Numeric code based on Currency Code.
	 * 
	 * @param lCurrencyCode
	 * @return
	 */
	private static String getCurrencyNumericCode(String lCurrencyCode) {
		boolean lIsNumericCodeFound = false;
	    Set<java.util.Currency> lCurrencies = java.util.Currency.getAvailableCurrencies();
	    for (java.util.Currency lCurrency : lCurrencies) {
	        if (lCurrency.getCurrencyCode().equals(lCurrencyCode)) {
	        	lIsNumericCodeFound = true;
	            return Integer.toString(lCurrency.getNumericCode());
	        }
	    }
	    
	    if(!lIsNumericCodeFound)
	    {
	    	throw new IllegalArgumentException("Currency with code ["  + lCurrencyCode + "] not found.");
	    }
	    //Code will not reach at this point. Both true and false condition is handled.
		return null;
	}
	
	/**
	 * Equal method for this class.
	 */
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		final Currency currency = (Currency) o;
		return this.numericCode.equals(currency.numericCode);
	}

	public int hashCode()
	{
		return hashCode;
	}

	/**
	 * Gets the ISO 4217 currency code of this currency.
	 *
	 * @return the ISO 4217 currency code of this currency.
	 */
	public String getCurrencyCode()
	{
		return javaCurrency.getCurrencyCode();
	}

	/**
	 * Gets the symbol of this currency for the default locale.
	 * For example, for the US Dollar, the symbol is "$" if the default
	 * locale is the US, while for other locales it may be "US$". If no
	 * symbol can be determined, the ISO 4217 currency code is returned.
	 *
	 * @return the symbol of this currency for the default locale
	 */
	public String getSymbol()
	{
		return currencySymbolOverride == null ? javaCurrency.getSymbol() : currencySymbolOverride;
	}

	/**
	 * @return has the default currency symbol been overridden
	 */
	public boolean hasSymbolOverride()
	{
		return currencySymbolOverride != null;
	}

	/**
	 * Gets the symbol of this currency for the specified locale.
	 * For example, for the US Dollar, the symbol is "$" if the specified
	 * locale is the US, while for other locales it may be "US$". If no
	 * symbol can be determined, the ISO 4217 currency code is returned.
	 *
	 * @param locale the locale for which a display name for this currency is
	 *               needed
	 * @return the symbol of this currency for the specified locale
	 * @throws NullPointerException if <code>locale</code> is null
	 */
	public String getSymbol(Locale locale)
	{
		return javaCurrency.getSymbol(locale);
	}

	/**
	 * Gets the three-digit numeric code for this currency.
	 *
	 * @return the three-digit numeric code for this currency.
	 */
	public String getNumericCode()
	{
		return numericCode;
	}

	/**
	 * @return the number of sub-units of the base currency
	 */
	public int getScale()
	{
		return scale;
	}

	/**
	 * Gets the description for this currency (i.e. "US dollar")
	 *
	 * @return the description for this currency.
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Gets the default number of fraction digits used with this currency.
	 * For example, the default number of fraction digits for the Euro is 2,
	 * while for the Japanese Yen it's 0.
	 * In the case of pseudo-currencies, such as IMF Special Drawing Rights,
	 * -1 is returned.
	 *
	 * @return the default number of fraction digits used with this currency
	 */
	public int getDefaultFractionDigits()
	{
		return javaCurrency.getDefaultFractionDigits();
	}

	/**
	 * Returns the ISO 4217 currency code of this currency.
	 *
	 * @return the ISO 4217 currency code of this currency
	 */
	public String toString()
	{
		return javaCurrency.toString();
	}

	/**
	 * Get Java Currency.
	 * 	
	 * @return
	 */
    public java.util.Currency getJavaCurrency()
	{
		return javaCurrency;
	}
}
