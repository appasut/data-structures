package Arrays;
/*
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
 */
public class ArrayBalance {
    public static void main(String[] args){
        //int[] arr = { 1,17,9,7,11};
        int[] arr = { 1,1,9,7,11};
        //int[] arr = { 0,0,0};
        int res=findEqualSumPoint(arr,arr.length);
        System.out.println(res);
    }

    private static int findEqualSumPoint(int[] nums, int n) {
        int sum=0;
        int leftsum=0,rightsum=0;

        for(int e:nums){
            sum+=e;
        }
        for(int i=0;i<nums.length;i++){
            rightsum=sum-leftsum-nums[i];
            if(leftsum==rightsum){
                return i;
            }else{
                leftsum+=nums[i];
            }
        }
        return -1;
    }
}
/*
Time Complexity: O(n)
Space Complexity: Q(1)
 */