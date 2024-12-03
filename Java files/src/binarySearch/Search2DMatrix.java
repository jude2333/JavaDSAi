package binarySearch;

public class Search2DMatrix {
    public boolean findTarget(int[][] nums, int target){

        int rows = nums.length;
        int cols = nums[0].length;

        int left = 0, right = rows-1;
        int mid = (left + right )/2;

        // for checking the current row
        while(left <= right){

            if(nums[mid][0] == target){
                return true;

            } else if (nums[mid][0] < target && nums[mid][cols-1] > target) {
                left = mid; // target in current row
                break;

            } else if (nums[mid][0] < target) {
                left = mid + 1;

            }else{
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }


        int row = left; // assigning the target row value, we assigned earlier through mid.
        left = 0;
        right = cols-1;
        mid = (left + right) / 2;

        // general binary search for the target row
        while(left <= right){
            if(nums[row][mid] > target){
                right = mid - 1;

            } else if (nums[row][mid] == target) {
                System.out.println("true");
                return true;

            }else{
                left = mid + 1;
            }
            mid = (left + right) / 2;

        }
        System.out.println("false");
        return false;

    }

    // this method is flattening the 2d array into 1d array
    public boolean findTarget2OnePass(int[][] matrix, int target){

        int ROWS = matrix.length, COLS = matrix[0].length;
        int l = 0, r = ROWS * COLS - 1; // for flattened 1d array.

        while (l <= r){
            int mid = l + (r-l)/2; // for not overflow of integers > 2^31 - 1;(for large arrays) --> equal to l+r/2
            int row = mid/COLS, col = mid%COLS; // for calculating the exact row and exact column.
            if(matrix[row][col] < target){
                l = mid + 1;
            } else if (matrix[row][col] == target) {
                return true;

            }else {
                r = mid - 1;
            }
        }
        return false;
    }



    public static void main(String[] args){
        int[][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

//        Search2DMatrix search2DMatrix = new Search2DMatrix();
//        System.out.println(search2DMatrix.findTarget(nums, target));

        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.findTarget2OnePass(nums, target));
    }

}
