package com.Currency.Constants;

/**
 * 
 * Currency Enum.
 * 
 * @author vipult
 *
 */
public enum CurrencyEnum {
	
	USD{	
		@Override
		public String toString()
		{
			return "US dollar";
		}
	},
	HKD{		
		@Override
		public String toString()
		{
			return "Hong Kong dollar";
		}
		
	},
	MYR{		
		@Override
		public String toString()
		{
			return "Malaysian ringgit";
		}
		
	}

}
