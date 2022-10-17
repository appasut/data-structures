package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C.
 */
public class CommonElements {
	public static void main(String[] args) {

		int n1 = 6;
		int[] A = {1, 5, 10, 20, 40, 80};
		int n2 = 5;
		int[] B = {6, 7, 20, 80, 100};
		int n3 = 8;
		int[] C = {3, 4, 15, 20, 30, 70, 80, 120};

		findCommonElements(A, n1, B, n2, C, n3).stream().forEach(e -> System.out.println(e + " "));

	}

	private static List<Integer> findCommonElements(int[] a, int n1, int[] b, int n2, int[] c, int n3) {
		ArrayList<Integer> res = new ArrayList<>();
		Set<Integer> s1 = new TreeSet<Integer>();
		Set<Integer> s2 = new TreeSet<Integer>();
		Set<Integer> s3 = new TreeSet<Integer>();
		for (int e : a) {
			s1.add(e);
		}
		for (int e : b) {
			s2.add(e);
		}
		for (int e : c) {
			s3.add(e);
		}
		s3.stream().forEach(x -> {
			if (s1.contains(x) && s2.contains(x))
				res.add(x);
		});
		return res;

	}
}
