package Arrays;

import java.math.BigInteger;

/*
Given an integer N, find its factorial.

Example 1:

Input: N = 5
Output: 120
Explanation : 5! = 1*2*3*4*5 = 120
Example 2:

Input: N = 10
Output: 3628800
Explanation :
10! = 1*2*3*4*5*6*7*8*9*10 = 3628800
 */
public class FactorialLargeNumber {
	public static void main(String[] args) {
		int[] res = new int[500];
		res[0] = 1;
		int res_size = 1;
		int N = 10;
		for (int i = 2; i <= N; i++) {
			res_size = multiply(i, res, res_size);
		}
		for (int i = res_size - 1; i >= 0; i--) {
			System.out.print(res[i] + " ");
		}
		multiply();
	}

	// Use simple multiplication steps
	private static int multiply(int x, int[] res, int res_size) {
		int c = 0;
		for (int i = 0; i < res_size; i++) {
			int prod = res[i] * x + c;
			res[i] = prod % 10;
			c = prod / 10;
		}
		while (c != 0) {
			res[res_size] = c % 10;
			c = c / 10;
			res_size++;
		}
		return res_size;
	}

	static void multiply() {
		BigInteger bigInteger = new BigInteger("1");
		for (int i = 2; i <= 10; i++) {
			bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
		}
		System.out.println(bigInteger);
	}
}
