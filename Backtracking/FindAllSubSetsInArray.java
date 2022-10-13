package Backtracking;

import java.util.ArrayList;

/*
Given an array, generate all the possible subarrays of the given array using recursion.
Examples:

Input : [1, 2, 3]
Output : [1], [1, 2], [2], [1, 2, 3], [2, 3], [3]

Input : [1, 2]
Output : [1], [1, 2], [2]
 */
public class FindAllSubSetsInArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		subsets(arr, 0, new ArrayList<Integer>(), arr.length, result);
		System.out.print(result);
	}

	private static void subsets(int[] arr, int start, ArrayList<Integer> subset, int end, ArrayList<ArrayList<Integer>> result) {
		result.add(new ArrayList<>(subset));
		for (int i = start; i < end; i++) {
			subset.add(arr[i]);
			subsets(arr, i + 1, subset, end, result);
			subset.remove(subset.size() - 1);
		}
		return;
	}

}
