/*

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2

Example 2:

Input: [1,3,5,6], 2
Output: 1

Example 3:

Input: [1,3,5,6], 7
Output: 4

Example 4:

Input: [1,3,5,6], 0
Output: 0



*/


class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target <= nums[0]){
            return 0;
        } else if(target > nums[nums.length-1]){
            return nums.length;
        } else {
            return binarySeachIndex(nums, 0, nums.length - 1, target);
        }
    }
    
    private int binarySeachIndex(int nums[], int left, int right, int target){
        if(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                if(left <= mid-1 && nums[mid-1] == target){
                    return mid-1;
                }
                if(left <= mid-1 && nums[mid-1] < target){
                    return mid;
                }
                return binarySeachIndex(nums, left, mid-1, target);
            } else{
                if(mid+1 <= right && nums[mid+1] == target){
                    return mid+1;
                }
                if(mid+1 <= right && nums[mid+1] > target){
                    return mid+1;
                }
                return binarySeachIndex(nums, mid+1, right, target);
            }
        }
        return -1;
    }
}