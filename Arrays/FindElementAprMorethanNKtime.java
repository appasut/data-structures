package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of size n, find all elements in array that appear more than n/k times.
For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3].
Note that size of array is 8 (or n = 8), so we need to find all elements that appear more than 2 (or 8/4) times.
There are two elements that appear more than two times, 2 and 3.
 */
public class FindElementAprMorethanNKtime {
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
		find(arr, arr.length, 4).stream().forEach(x -> {
			System.out.print(x + " ");
		});
	}

	private static List<Integer> find(int[] arr, int n, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		Arrays.sort(arr);
		int[] freq = new int[arr[n - 1] + 1];
		for (int i = 0; i < n; i++) {
			freq[arr[i]]++;
		}
		for (int j = 0; j < freq.length; j++) {
			if (freq[j] > n / k)
				ans.add(j);
		}
		return ans;
	}
}
