public class StockBestTime {
    public int bestTime(int[] nums){

//        two pointer technique
        int left=0,right=1,max=0;
        while(right < nums.length){
            if(nums[left] < nums[right]){
                max = Math.max(max, nums[right] - nums[left]);

            }else{
                left = right;
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args){
        StockBestTime stockBestTime = new StockBestTime();
        int[] nums = {2,7,11,15};
        System.out.println(stockBestTime.bestTime(nums));
    }
}
