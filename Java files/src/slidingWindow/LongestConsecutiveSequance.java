package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequance {
    public static int longestConsecutive(int[] nums){


        Set<Integer> numsSet = new HashSet<>();
        for(int num:nums){
            numsSet.add(num);
        }

        int longest = 1;
        for(int num : nums){
            int count = 1;
            if(!numsSet.contains(num - 1)){
                while(numsSet.contains(num + 1)){
                    num ++;
                    count ++;

                }
            }
            longest = Math.max(count,longest);
        }
        System.out.println(longest);
        return longest;
    }

    public static void main(String[] args){
        int[] nums = {100,3,2,1,99};
        longestConsecutive(nums);
    }
}
