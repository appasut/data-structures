package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/*
You are given two integers L and R. Your task is to determine the sum of all the beautiful numbers from the range [L,R].
A number represents a beautiful number if it satisfies the following condition:

If the number becomes 1 at some point by replacing it repeatedly with the sum of squares of its digits.
Note: If the number never becomes 1, then the provided number is not a beautiful number.
For further clarification, please refer to the explanation of the sample test case.

Example

Consider L=1, R = 2. You have to determine the sum of all the beautiful numbers from the range [L,R].
Here the answer is 1 as 2 is not a beautiful number.
 */
public class BeautifullNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		long[] presum = preprocess();
		for (int t_i = 0; t_i < T; t_i++) {
			String[] str = br.readLine().split(" ");
			int l = Integer.parseInt(str[0]);
			int r = Integer.parseInt(str[1]);

			long out_ = solve(l, r, presum);
			System.out.println(out_);
		}

		wr.close();
		br.close();
	}

	static long solve(int l, int r, long[] presum) {
		return (presum[r] - presum[l - 1]);
	}

	static boolean isBeautifullNumber(int n) {
		int i = 0;
		while (i < 10) {
			int sum = 0;
			int number = n;
			while (number > 0) {
				int rem = number % 10;
				sum += Math.pow(rem, 2);
				number = number / 10;
			}
			n = sum;
			if (n == 1) {
				return true;
			}
			i++;
		}
		return false;
	}

	static long[] preprocess() {
		long[] presum = new long[1000005];
		for (int i = 1; i < presum.length; i++) {
			presum[i] += presum[i - 1];
			presum[i] += isBeautifullNumber(i) ? i : 0;
		}
		return presum;
	}
}