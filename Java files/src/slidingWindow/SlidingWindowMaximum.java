package slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class SlidingWindowMaximum {
    public int[] findMaximum(int[] nums, int k){

        //int[] res =
        Deque<Integer> q = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        int left = 0;
        for(int i=0;i<nums.length;i++){
            if(!q.isEmpty() && q.peekFirst() < i-k+1){
                q.pollFirst();

            }

            while(!q.isEmpty() && nums[i] > q.peekFirst()){
                q.pollFirst();
            }

            q.offer(i);
            if(i >= k-1){
                result[left++] = nums[q.peekFirst()];
            }
        }
        System.out.println(Arrays.toString(result));

        return result;

    }

    public static void main(String[] args){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        slidingWindowMaximum.findMaximum(nums, k);







    }
}
