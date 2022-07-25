package com.kol.lc.july.twenty.two;

public class FirstAndLastPositionOfElementInSortedArray {


    public int[] searchRange(int[] nums, int target) {

        int res[] = new int[2];

        res[0] = findLeftMostOccurence(nums,target);
        res[1] = findRightMostOccurence(nums,target);

        return res;


    }

    private int findLeftMostOccurence(int[] nums, int target) {

        int idx = -1;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {

            int mid = left + (right - left) /2;

            if(nums[mid] >= target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }

            if(nums[mid] == target) idx = mid;

        }

        return idx;
    }

    private int findRightMostOccurence(int[] nums, int target) {

        int idx = -1;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {

            int mid = left + (right - left) /2;
            if(nums[mid] <= target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }

            if(nums[mid] == target) idx = mid;

        }

        return idx;
    }
}
