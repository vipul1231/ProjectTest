package com.walkerdigital.toolkit.money;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by GW on 28/01/2017.
 */
public class CurrencyTest {

    static HashMap<String, Currency> cache = new HashMap<String, Currency>();

    static HashMap<String, Currency> codeCurrencyMap = new HashMap<String, Currency>();

    static Currency currencyUSD, currencyHKD, currencyMYR, cacheUSD, cacheHKD, cacheMYR;

    @BeforeClass
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        for (Class clazz : Currency.class.getDeclaredClasses()) {
            if ("com.walkerdigital.toolkit.money.Currency.CurrencyCache".equals(clazz.getCanonicalName())) {
                Class currencyCacheClass = clazz;
                Field cacheField = currencyCacheClass.getDeclaredField("cache");
                cacheField.setAccessible(true);
                cache = (HashMap<String, Currency>) cacheField.get(null);


           /*     Field codeCurrencyMapField = currencyCacheClass.getDeclaredField("codeCurrencyMap");
                codeCurrencyMapField.setAccessible(true);
                codeCurrencyMap = (HashMap<String, Currency>) codeCurrencyMapField.get(null);*/
                break;
            }
        }
        currencyUSD = Currency.newInstance(java.util.Currency.getInstance("USD"), "840", 100);
        currencyHKD = Currency.newInstance(java.util.Currency.getInstance("HKD"), "344", 100);
        currencyMYR = Currency.newInstance(java.util.Currency.getInstance("MYR"), "344", 100, "RM");


        cacheHKD = cache.get("HKD_344__100");
        cacheUSD = cache.get("USD_840__100");
        cacheMYR = cache.get("MYR_344_RM_100");
    }

    @Test
    public void getByCurrencyCode() throws Exception {
        assertEquals(Currency.getByCurrencyCode("USD"), cacheUSD);
        assertEquals(Currency.getByCurrencyCode("MYR"), cacheMYR);
        assertEquals(Currency.getByCurrencyCode("RM"), null);
        assertEquals(Currency.getByCurrencyCode("HKD"), cacheHKD);

    }

    @Test
    public void getByCurrencyAbbreviationOrSymbol() throws Exception {
        assertEquals(Currency.getByCurrencyAbbreviationOrSymbol("USD"), cacheUSD);
        assertEquals(Currency.getByCurrencyAbbreviationOrSymbol("MYR"), cacheMYR);
        assertEquals(Currency.getByCurrencyAbbreviationOrSymbol("RM"), cacheMYR);
        assertEquals(Currency.getByCurrencyAbbreviationOrSymbol("HKD"), cacheHKD);
    }

    @Test
    public void newInstance() throws Exception {
        assertTrue(cache.size() == 3);
        assertNotNull(Currency.newInstance(java.util.Currency.getInstance("INR"), "111", 100));
        assertTrue(cache.size() == 4);
    }

}