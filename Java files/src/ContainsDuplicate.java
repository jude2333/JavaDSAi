import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean isDuplicate(int[] nums){

        Map<Integer, Integer> storePrevNums = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            int num = nums[i];

            storePrevNums.put(num, storePrevNums.getOrDefault(num, 0) + 1);
            if(storePrevNums.containsKey(nums[i]) && storePrevNums.get(nums[i]) > 1){
                return true;
            }

        }
        return false;

    }

    public static void main(String[] args){
        int[] nums = {1,2, 3, 4};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.isDuplicate(nums));
    }
}
