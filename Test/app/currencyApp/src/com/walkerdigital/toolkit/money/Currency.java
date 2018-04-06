package com.walkerdigital.toolkit.money;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;


public class Currency implements Serializable {
    private static final long serialVersionUID = 8228779577409316939L;

    private final java.util.Currency javaCurrency;
    private final String numericCode;
    private final String currencySymbolOverride; // use to override the currency code in java.util.Currency
    private final String description;
    private final int hashCode;
    private final int scale; // the number of sub-units of the currency (e.g. US dollars have 100 sub-units, or pennies)

    private static class CurrencyCache{

        // supported currency codes
        private static final String CURRENCY_CODE_USD = "USD";
        private static final String CURRENCY_CODE_HKD = "HKD";
        private static final String CURRENCY_CODE_MYR = "MYR";
        private static final String CURRENCY_SYMBOL_USD = "$";
        private static final String CURRENCY_SYMBOL_HKD = "HK$";
        private static final String CURRENCY_SYMBOL_RM = "RM";

        private static HashMap<String, Currency> cache = new HashMap<String, Currency>();
        private static HashMap<String, Currency> codeCurrencyMap = new HashMap<String, Currency>();
        private static HashMap<String, Currency> symbolCurrencyMap = new HashMap<String, Currency>();

        static {
            // supported currencies
            final Currency US_DOLLAR = new Currency(java.util.Currency.getInstance(CURRENCY_CODE_USD), "840", 100);
            final Currency HK_DOLLAR = new Currency(java.util.Currency.getInstance(CURRENCY_CODE_HKD), "344", 100);
            final Currency MALAYSIAN_RINGGIT = new Currency(java.util.Currency.getInstance(CURRENCY_CODE_MYR), "344", 100, CURRENCY_SYMBOL_RM);

            cache.put(US_DOLLAR.description, US_DOLLAR);
            cache.put(HK_DOLLAR.description, HK_DOLLAR);
            cache.put(MALAYSIAN_RINGGIT.description, MALAYSIAN_RINGGIT);

            // Limitation : We are supporting only one symbol(our default one) for a given currency code
            codeCurrencyMap.put(CURRENCY_CODE_USD, US_DOLLAR);
            codeCurrencyMap.put(CURRENCY_CODE_HKD, HK_DOLLAR);
            codeCurrencyMap.put(CURRENCY_CODE_MYR, MALAYSIAN_RINGGIT);

            symbolCurrencyMap.put(CURRENCY_CODE_USD, US_DOLLAR);
            symbolCurrencyMap.put(CURRENCY_CODE_HKD, HK_DOLLAR);
            // MALAYSIAN_RINGGIT maps to both CURRENCY_CODE_MYR and CURRENCY_SYMBOL_RM
            symbolCurrencyMap.put(CURRENCY_CODE_MYR, MALAYSIAN_RINGGIT);
            symbolCurrencyMap.put(CURRENCY_SYMBOL_RM, MALAYSIAN_RINGGIT);

        }
    }

    /**
     * default constructor was added to work with jaxb generation / conversion
     */
    public Currency() {
        javaCurrency = null;
        numericCode = null;
        currencySymbolOverride = null;
        description = null;
        hashCode = 0;
        scale = 0;
    }

    /**
     * Constructor to use the currency code from java.util.Currency
     *
     * @param pCurrency
     * @param pNumericCode
     * @param pScale
     */
    private Currency(java.util.Currency pCurrency, String pNumericCode, int pScale) {
        this(pCurrency, pNumericCode, pScale, null);
    }

    /**
     * Constructor to override the currency code in java.util.Currency
     *
     * @param pCurrency
     * @param pNumericCode
     * @param pScale
     * @param pCurrencySymbolOverride
     */
    private Currency(java.util.Currency pCurrency, String pNumericCode, int pScale, String pCurrencySymbolOverride) {
        javaCurrency = pCurrency;
        numericCode = pNumericCode;
        final StringBuilder currencyDescription = new StringBuilder();
        currencyDescription.append(pCurrency).append('_');
        currencyDescription.append(pNumericCode).append('_');
        currencyDescription.append(pCurrencySymbolOverride!=null?pCurrencySymbolOverride:"").append('_');
        currencyDescription.append(pScale);
        description= currencyDescription.toString();
        hashCode = hashCode();
        scale = pScale;
        currencySymbolOverride = pCurrencySymbolOverride;
    }

    /**
     * Get a {@link Currency} by its ISO 4217 code
     *
     * @param pCurrencyCode
     * @return the currency for the given code, or null if the code is not supported
     */
    public static Currency getByCurrencyCode(String pCurrencyCode) {
        return CurrencyCache.codeCurrencyMap.get(pCurrencyCode);
    }

    public static Currency getByCurrencyAbbreviationOrSymbol(String pCurrencyAbbreviationOrSymbol) {
      return CurrencyCache.symbolCurrencyMap.get(pCurrencyAbbreviationOrSymbol);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Currency{");
        sb.append("javaCurrency=").append(javaCurrency);
        sb.append(", numericCode='").append(numericCode).append('\'');
        sb.append(", currencySymbolOverride='").append(currencySymbolOverride).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", scale=").append(scale);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Is the given currency code supported in the system?
     *
     * @param pCurrencyCode
     * @return
     */
    public static boolean isSupportedCurrencyCode(String pCurrencyCode) {
        //return getByCurrencyCode(pCurrencyCode) != null;
    	return CurrencyCache.codeCurrencyMap.containsKey(pCurrencyCode);
    }

    /**
     * Creates a new instance, will only be used by Jaxb.
     */
    public static Currency newInstance() {
        return new Currency();
    }
    public static Currency newInstance(java.util.Currency pCurrency, String pNumericCode, int pScale) {
        return newInstance(pCurrency,  pNumericCode,  pScale, null);
    }

    public static Currency newInstance(java.util.Currency pCurrency, String pNumericCode, int pScale, String pCurrencySymbolOverride) {
        final StringBuilder currencyDescription = new StringBuilder();
        currencyDescription.append(pCurrency).append('_');
        currencyDescription.append(pNumericCode).append('_');
        currencyDescription.append(pCurrencySymbolOverride!=null?pCurrencySymbolOverride:"").append('_');
        currencyDescription.append(pScale);
        final String pDescription = currencyDescription.toString();

        synchronized (CurrencyCache.class){
            Currency instance = CurrencyCache.cache.get(pDescription);
            if(instance != null){
                return instance;
            }else{
                Currency currency = new Currency(pCurrency, pNumericCode, pScale, pCurrencySymbolOverride);
                CurrencyCache.cache.put(pDescription, currency);
                if(!CurrencyCache.codeCurrencyMap.containsKey(pCurrency.getCurrencyCode())){
                    CurrencyCache.codeCurrencyMap.put(pCurrency.getCurrencyCode().toUpperCase(),currency);
                }
                if(!CurrencyCache.symbolCurrencyMap.containsKey(currency.getSymbol())){
                    CurrencyCache.codeCurrencyMap.put(currency.getSymbol().toUpperCase(),currency);
                }
                return currency;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Currency currency = (Currency) o;
        return currency.getJavaCurrency().equals(javaCurrency) && currency.getNumericCode().equals(numericCode) && currency.currencySymbolOverride.equals(currencySymbolOverride) && currency.getScale() == scale;
           //  equals only used the numericCode for checking equality -This was incorrect as all significant fields should be used
           //	return numericCode.equals(currency.numericCode);
    }

    // We need to override hashCode as we have overridden equals
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + javaCurrency.hashCode();
        result = 31 * result + numericCode.hashCode();
        result = 31 * result + ((currencySymbolOverride != null) ? currencySymbolOverride.hashCode() : 0);
        result = 31 * result + scale;
        return result;
    }

    /**
     * Gets the ISO 4217 currency code of this currency.
     *
     * @return the ISO 4217 currency code of this currency.
     */
    public String getCurrencyCode() {
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
    public String getSymbol() {
        return currencySymbolOverride == null ? javaCurrency.getSymbol() : currencySymbolOverride;
    }

    /**
     * @return has the default currency symbol been overridden
     */
    public boolean hasSymbolOverride() {
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
    public String getSymbol(Locale locale) {
        return javaCurrency.getSymbol(locale);
    }

    /**
     * Gets the three-digit numeric code for this currency.
     *
     * @return the three-digit numeric code for this currency.
     */
    public String getNumericCode() {
        return numericCode;
    }

    /**
     * @return the number of sub-units of the base currency
     */
    public int getScale() {
        return scale;
    }

    /**
     * Gets the description for this currency (i.e. "US dollar")
     *
     * @return the description for this currency.
     */
    public String getDescription() {
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
    public int getDefaultFractionDigits() {
        return javaCurrency.getDefaultFractionDigits();
    }

    public java.util.Currency getJavaCurrency() {
        return javaCurrency;
    }

}
