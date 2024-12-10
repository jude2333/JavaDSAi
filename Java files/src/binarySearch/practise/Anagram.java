package binarySearch.practise;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
    public boolean isAnagram(int[] nums){

        List<Integer> seened = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(seened.contains(nums[i])){
                return true;
            }
            seened.add(nums[i]);
        }

        return false;
    }


}
