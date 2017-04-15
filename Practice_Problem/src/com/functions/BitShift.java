package com.functions;

public class BitShift {
    
    public static Integer divideBy2(int a){
	return a>>1;
    }
    
    public static Integer multiplyBy2(int a){
	return 1<<a;
    }
    
    public static void main(String[] args){
	int b =8;
	b>>=1;
	System.out.println(b);
	System.out.println(8<<1);
    }
}
