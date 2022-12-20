package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an array of integers arr[] of length N, every element appears thrice except for one which occurs once.
Find that element which occurs once.
Example 1:

Input:
N = 4
arr[] = {1, 10, 1, 1}
Output:
10
Explanation:
10 occurs once in the array while the other
element 1 occurs thrice.
 */
public class Findelementoccuringonce {
	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 2, 2, 4, 4,};
		System.out.print(singleElement(arr, arr.length));
	}

	static int singleElement(int[] arr, int N) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		List<Integer> ans = new ArrayList<>();
		map.entrySet().forEach(e -> {
			if (e.getValue() <= 1) {
				ans.add(e.getKey());
			}
		});
		return ans.size() == 1 ? ans.get(0) : -1;
	}
}
