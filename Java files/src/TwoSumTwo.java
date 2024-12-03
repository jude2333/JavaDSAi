import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumTwo {
    public int[] twoSum(int[] nums, int target){

        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]) + 1;
                res[1] = i + 1;


            }
            map.put(nums[i],i);
        }
        System.out.println(Arrays.toString(res));

        return res;
    }

    public int[] twoSumtwo2(int[] nums, int target){
        int a_pointer = 0;
        int b_pointer = nums.length-1;

        while(a_pointer < b_pointer){
            // [1,4,5,6,2,8,9], target=3
            if(nums[a_pointer] + nums[b_pointer] == target){
                break;

            }

            if(nums[a_pointer] + nums[b_pointer] > target){
                b_pointer--;
                continue;
            }
            a_pointer++;
        }
        System.out.println(a_pointer + " " + b_pointer);
        return new int[] {a_pointer + 1, b_pointer + 1};

    }

    public static void main(String[] args){
        TwoSumTwo twoSumTwo = new TwoSumTwo();
        int[] nums = {2,3,4,8,9};
        int target = 6;

        System.out.println(twoSumTwo.twoSumtwo2(nums,target));
    }
}
