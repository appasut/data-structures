package Arrays;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 */
public class FindDupNumber {
	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 2, 2};
		System.out.print(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
		boolean[] check = new boolean[nums.length - 1];
		for (int i = 0; i < nums.length; i++) {
			if (check[nums[i] - 1]) {
				return nums[i];
			} else {
				check[nums[i] - 1] = true;
			}
		}
		return 0;

	}
}
