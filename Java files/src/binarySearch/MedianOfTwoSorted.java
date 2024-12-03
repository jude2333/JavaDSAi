package binarySearch;

import javax.print.attribute.standard.Media;

public class MedianOfTwoSorted {
    public double findMedian(int[] nums1, int[] nums2){
        // performing merge sort to merge the arrays.
        int i=0, j=0, k=0;
        int n = nums1.length + nums2.length;
        int[] res = new int[n];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                res[k] = nums1[i];
                i++;
            }else{
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < nums1.length){
            res[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            res[k] = nums2[j];
            j++;
            k++;
        }
        // will find median of merged array
        return median(res);
    }

    public double median(int[] nums){

        int l = 0, r = nums.length-1;
        int m = (l+r)/2;

        if((nums.length % 2) == 0){// if the array is even means we want to split theroritically
            // end value of first array, start value of second array
            int end1 = m - l, start2 = r - m;
            return ((double) nums[end1] + nums[start2])/2;

        }else{// if its odd we can simply return the mid.
            return (double) nums[m];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2};
        MedianOfTwoSorted medianOfTwoSorted = new MedianOfTwoSorted();
        System.out.println(medianOfTwoSorted.findMedian(nums1,nums2));
    }
}
