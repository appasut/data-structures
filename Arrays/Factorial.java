package Arrays;

/*
Given an integer n, write a function that returns count of trailing zeroes in n!.
Examples :

Input: n = 5
Output: 1
Factorial of 5 is 120 which has one trailing 0.
 */
public class Factorial {
	public static void main(String[] args) {
		int n = 5;
		int temp = factorial(n);
		int count = 0;
		while (temp > 0) {
			int d = temp % 10;
			temp = temp / 10;
			if (d != 0) {
				break;
			}
			count++;
		}
		System.out.println("count:" + count);
	}

	static int factorial(int n) {
		if (n < 2) {
			return n;
		}
		return n * factorial(n - 1);
	}
}
