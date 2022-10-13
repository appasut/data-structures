package Arrays;

import java.util.ArrayList;

/*
Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to check whether a2[] is a subset of a1[] or not.
Both the arrays can be sorted or unsorted. It may be assumed that elements in both array are distinct.
Input:
    a1[] = {11, 1, 13, 21, 3, 7}
    a2[] = {11, 3, 7, 1}
Output:
    Yes
Explanation:
    a2[] is a subset of a1[]

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

 */
public class ArrayIsSubsetOfAnother {
	public static void main(String[] args) {
		long a1[] = {11, 1, 13, 21, 3, 7};
		long a2[] = {11, 3, 7, 1};
		System.out.println(isSubSet(a1, a2));
	}

	private static String isSubSet(long[] a1, long[] a2) {
		ArrayList<Long> list = new ArrayList<>();
		for (long e : a1) {
			list.add(e);
		}
		for (long e : a2) {
			if (!list.contains(e)) {
				return "No";
			}
		}
		return "Yes";
	}
}
