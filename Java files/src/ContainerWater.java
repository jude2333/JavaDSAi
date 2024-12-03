public class ContainerWater {

    public int mostWater(int[] nums){

        int left = 0, right = 1, Max = 0;
        while(right < nums.length){
            if(nums[left] >= nums[right]){
                Max =  Math.max(Max, (right - left) * nums[right]);
            }else{
                left = right;
            }
            right++;

        }
        return Max;
    }




    public static void main(String[] args){ 
        int[] nums = {1,8,6,2,5,4,8,3,7};
        ContainerWater containerWater = new ContainerWater();
        System.out.println(containerWater.mostWater(nums));

    }
}
