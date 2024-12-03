import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] two_sum(int[] nums, int target){
        Map<Integer, Integer> storePrevNums = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            int currNum = nums[i];

            if(storePrevNums.containsKey(target-currNum)){
                int[] result = {storePrevNums.get(target-currNum),i};
                return result;
            }
            storePrevNums.put(currNum, i);
        }
        int[] g = new int[2];
        return g;
    }




    public static void main(String[] args){
        int[] nums = {1,2,0,1};
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.two_sum(nums,6));

    }
}
