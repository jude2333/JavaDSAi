package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// time complexity O(log(n))
public class RotatedSortedArray {
    public int findMin(int[] nums){

        int l = 0, r = nums.length-1;
        int res = nums[0];
        while(l <= r){

            int m = l + (r-l) / 2; // to avoid numbers overflow for int datatype, for large datasets
            // special case
            if(nums[l] < nums[r]){
                res = Math.min(res, nums[l]);
                break;
            }

            res = Math.min(res, nums[m]);
            if(nums[m] >= nums[l]){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
        System.out.println(rotatedSortedArray.findMin(nums));
    }
}
