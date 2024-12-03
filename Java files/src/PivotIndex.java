import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PivotIndex {
    public int pivot(int[] nums){

        int total = Arrays.stream(nums).sum(); // to sum up the entire sum
//        System.out.println(total);
        int leftsum = 0;

        for (int i=0;i<nums.length;i++){
            // when reach the pivot index we can identify the rightsum if there is a pivot, here nums[i] is the changing pivot
            int rightsum = total - nums[i] - leftsum;
            // if there is a pivot find means return the index
            if (leftsum == rightsum){
                return i;
            }
            leftsum += nums[i];

        }
        return -1;
    }


    public static void main(String[] args){
        int[] nums = {1,7,3,6,5,6};
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivot(nums));
    }


}
