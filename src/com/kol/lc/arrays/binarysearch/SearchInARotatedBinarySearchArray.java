package com.kol.lc.arrays.binarysearch;

public class SearchInARotatedBinarySearchArray {

    public static void main(String[] args) {
        //System.out.println(findInSortedRotatedArray(new int [] {4,5,6,7,0,1,2}, 2));
        System.out.println(findInSortedRotatedArray(new int [] {3,1}, 1));
    }




    public static int findInSortedRotatedArray(int nums[], int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right && nums[left] > nums[right]) {

            int mid = left + (right - left)/2 ;
            if(nums[mid] >= nums[left]) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        // left will be pointing to the minimum element
        int start = left;

        //start the search in array
        left = 0;
        right = nums.length - 1;

        if(target >= nums[start] && target <= nums[right]) {
            left = start;
        }else{
           right = start;
        }

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(nums[mid] == target) {
                return mid;
            }else if(target > nums[mid]) {
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }

}


