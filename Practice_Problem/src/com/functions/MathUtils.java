package com.functions;

public class MathUtils {
    
    private static final int MOD = (int) (1e9 + 7);
    
    /**
     * Finds power through recursive call.
     * 
     * @param a
     * @param b
     * @return
     */
    public static Long powRecursive(Long a, Long b){
	
	if(b==0){
	    return 1l;
	}
	else{
	    return a * powRecursive(a, --b);
	}
    }
    
    /**
     * Simple power function.
     * 
     * long pow (long a, int b)
		{
    		if ( b == 0)        return 1;
    		if ( b == 1)        return a;
    		if (isEven( b ))    return     pow ( a * a, b/2); //even a=(a^2)^b/2
    		else                return a * pow ( a * a, b/2); //odd  a=a*(a^2)^b/2
		}
     * 
     * @param a
     * @param b
     * @return 
     */
    public static Long powSimple(Long a, Long b){
	long ret = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ret = ret * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return ret;
    }
    
    public static void main(String[] args){
	System.out.println(powRecursive(3l, 2l));
	System.out.println(powSimple(2l, 7l));
    }
}
