public class TrapWater {
    public int waterTrapped(int[] height){

        int leftMax[] = new int[height.length], right[] = new int[height.length], max = height[0];

        for(int i=0;i<height.length;i++){
            leftMax[i] = Math.max(height[i], max);
            max = leftMax[i];

        }

        for(int i=height.length-1;i>=0;i--){
            right[i] = Math.max(height[i], max);
            max = right[i];
        }

        int res = 0;
        for(int i=0;i<height.length;i++){
            // checking min height of left and right height so far and minus current height and adding prev res,
            // which is prev water blocks
            res = res + Math.min(leftMax[i], right[i]) - height[i];
        }

        return res;

    }

    public static void main(String[] args){
        TrapWater trapwater = new TrapWater();
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapwater.waterTrapped(heights));
    }
}
