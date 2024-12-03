public class MonotonicArray {
    public boolean monotonicArray(int[] nums) {
        int first = nums[0];
        int last = nums[nums.length - 1];

        if (first > last) {
            return monotonicDecreasingArray(nums);
        }else{
            return monotonicIncreasingArray(nums);
        }
    }

    public boolean monotonicIncreasingArray(int[] nums) {

        int prev = nums[0];
        int curr;

        for (int i = 0; i < nums.length; i++) {

            curr = nums[i];
            if (i > 0 && curr < prev) {
                return false;
            }
            prev = curr;

        }
        return true;

    }

    public boolean monotonicDecreasingArray(int[] nums) {

        int prev = nums[0];
        int curr;

        for (int i = 0; i < nums.length; i++) {


            curr = nums[i];

            if (i > 0 && curr > prev) {
                return false;
            }
            prev = curr;

        }
        return true;

    }

    public static void main(String[] args) {

        int[] nums = {4,4,4,4};
        MonotonicArray monotonicArray = new MonotonicArray();
        System.out.println(monotonicArray.monotonicArray(nums));
    }
}
