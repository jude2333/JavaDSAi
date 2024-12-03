import java.util.*;

public class Rough {
    public int roughProgram(int[] nums){

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int max=1;
        for(int n : nums){
            if(!set.contains(n-1)){
                int currMax = 0;
                while(set.contains(n)){
                 currMax++;
                 n++;
                }
                max = Math.max(currMax,max);
            }
        }
        return max;

    }

    public static int hash(int num, int bucketSize){
        return num/bucketSize;
    }

    public static void main(String[] args){

        int[] nums = {1,2,3,4,82};
        Rough rough = new Rough();
        System.out.println(rough.roughProgram(nums));
    }
}
