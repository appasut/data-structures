package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.

Example 1:

Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation:
arr[0] + arr[1] = 1 + 5 = 6
and arr[1] + arr[3] = 5 + 1 = 6.
 */
public class FindArraySummequaltoGivenNum {

	public static void main(String[] args) {
		int[] arr = {1, 5, 7, 1};
		System.out.println(getPairsCount(arr, arr.length, 6));
		getPairsCountBinarySearch(arr, arr.length, 6);

	}

	static int getPairsCount(int[] a, int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int tc = 0;
		for (int i = 0; i < n; i++) {
			if (map.containsKey(k - a[i]))
				tc = tc + map.get(k - a[i]);
			if (!map.containsKey(a[i]))
				map.put(a[i], 0);
			map.put(a[i], map.get(a[i]) + 1);
		}
		return tc;
	}

	static void getPairsCountBinarySearch(int[] a, int n, int k) {
		int low = 0;
		int high = n - 1;
		Arrays.sort(a);
		while (low < high) {
			if (a[low] + a[high] == k) {
				System.out.println("(" + a[low] + "," + a[high] + ")");
			}
			if (a[low] + a[high] > k) {
				high--;
			} else {
				low++;
			}
		}
	}
}
