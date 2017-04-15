package com.hackerrank;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
 
public class FavoriteSubsequence {
	private static final int MOD = (int) (1e9 + 7);
 
	private void solve(InputReader in, PrintWriter out) {
		char[] S = in.nextLine().toCharArray();
		int a = 0;
		long ab = 0;
		long abc = 0;
		for (int i = 0; i < S.length; i++) {
			switch (S[i]) {
			case 'a':
				a++;
				break;
 
			case 'b':
				ab = (pow(2, a) - 1 + (ab * 2)) % MOD;
				break;
 
			case 'c':
				abc = (ab + abc * 2) % MOD;
				break;
			}
		}
		out.println(abc);
	}
	
    private long pow(long a, int b) {
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
 
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		FavoriteSubsequence solver = new FavoriteSubsequence();
		solver.solve(in, out);
		out.close();
	}
}
 
class InputReader {
	private int curChar;
	private int numChars;
	private byte[] buf = new byte[1024];
	private InputStream stream = System.in;
 
	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	private String readLine0() {
		StringBuilder buf = new StringBuilder();
		int c = read();
		while (c != '\n' && c != -1) {
			if (c != '\r')
				buf.appendCodePoint(c);
			c = read();
		}
		return buf.toString();
	}
 
	public String nextLine() {
		String s = readLine0();
		while (s.trim().length() == 0)
			s = readLine0();
		return s;
	}
 
}
