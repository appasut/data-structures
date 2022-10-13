package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 */
public class CombinationOfNumber {
	public static void main(String[] args) {
		CombinationOfNumber combination = new CombinationOfNumber();
		combination.generate(4, 2).stream().forEach(System.out::println);
	}

	private List<List<Integer>> generate(int n, int r) {
		List<List<Integer>> combinations = new ArrayList<>();
		combinations(combinations, new int[r], 1, n, 0);
		return combinations;
	}

	private void combinations(List<List<Integer>> combinations, int[] data, int start, int end, int index) {
		if (index == data.length) {
			ArrayList<Integer> ans = new ArrayList<>();
			for (int e : data) {
				ans.add(e);
			}
			combinations.add(ans);
		} else if (start <= end) {
			data[index] = start;
			combinations(combinations, data, start + 1, end, index + 1);
			combinations(combinations, data, start + 1, end, index);
		}
	}
}
