package Arrays;

/*
Given an array of integers. Find the Inversion Count in the array.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
If array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5
has three inversions (2, 1), (4, 1), (4, 3).
 */
public class CountInversion {
	public static void main(String[] args) {
		int[] arr = {2, 4, 1, 3, 5};
		int[] ans = new int[1];
		//countInversion(arr,arr.length,ans);
		System.out.println(ans[0]);
		System.out.println(bubbleSort(arr));
	}

	private static void countInversion(int[] arr, int n, int[] ans) {
		mergeSort(arr, 0, n - 1, ans);
	}

	private static void mergeSort(int[] arr, int l, int r, int[] ans) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(arr, l, m, ans);
			mergeSort(arr, m + 1, r, ans);
			merge(arr, l, m, r, ans);
		}
	}

	private static void merge(int[] arr, int l, int m, int r, int[] ans) {

		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] < R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
				//Formally, two elements L[i] and R[j] form an inversion if L[i] > R[j] and i < j.
				ans[0] = ans[0] + n1 - i;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	private static int bubbleSort(int[] arr) {
		int n = arr.length;
		int inversioncount = 0;
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - i - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
					inversioncount++;
				}

			}
			if (swapped == false) {
				break;
			}
		}
		return inversioncount;

	}

}
