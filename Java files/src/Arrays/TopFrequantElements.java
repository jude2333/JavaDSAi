package Arrays;

import java.util.*;

public class TopFrequantElements {
    public static int[] topFrequant(int[] nums, int k) {

        List<Integer> buckets[] = new ArrayList[nums.length + 1];
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
            System.out.println(count);

        }

        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);

        }

        int index = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                   res[index++] = num;
                   if(i == k){
                       System.out.println(Arrays.toString(res));
                       return res;
                   }
                }
            }
        }

        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        topFrequant(nums, k);

    }

}
