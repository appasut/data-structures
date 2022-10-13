package Arrays;

import java.util.HashMap;

/*Given two arrays a[] and b[] of size n and m respectively. The task is to find union between these two arrays.
 Union of the two arrays can be defined as the set containing distinct elements from both the arrays.
 If there are repetitions, then only one occurrence of element should be printed in the union.

        Example 1:
        Input:
        5 3
        1 2 3 4 5
        1 2 3
        Output:
        5
        Explanation:
        1, 2, 3, 4 and 5 are the
        elements which comes in the union set
        of both arrays. So count is 5.

        Expected Time Complexity : O((n+m)log(n+m))
        Expected Auxilliary Space : O(n+m)
        */
public class ArrayUnionCount {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {1, 2, 3};
		System.out.print(doUnion(a, a.length, b, b.length));
	}

	public static int doUnion(int[] a, int n, int[] b, int m) {
		//Add all the elements to HashMap and return map size.
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}

		for (int i = 0; i < m; i++) {
			map.put(b[i], map.getOrDefault(b[i], 0) + 1);
		}

		return map.size();
	}
}
