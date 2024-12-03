package stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public int carFleetCount(int[] positions, int[] speed, int target){
        Stack<Integer> stack = new Stack<>();
        int[][] combined = new int[positions.length][2];

        for(int i=0;i<positions.length;i++){
            combined[i][0] = positions[i];
            combined[i][1] = speed[i];
        }

        // sorting the first column(value) of every row in combined
        Arrays.sort(combined, java.util.Comparator.comparingInt(o -> o[0]));
        // looping from backwards, because of the positions
        for(int i=combined.length-1;i>=0;i--){
            int currentTime = (target - combined[i][0]) / combined[i][1];
            if(!stack.isEmpty() && currentTime <= stack.peek()){
                continue; // no changes in stack
            }else{
                stack.push(currentTime);
            }
        }
        System.out.println(stack.size());
        return stack.size();
    }

    public static void main(String[] args) {
        int[] positions = {10,8,0,5,3}, speed = {2,4,1,1,3};
        int target = 12;
        CarFleet carFleet = new CarFleet();
        carFleet.carFleetCount(positions, speed, target);

    }
    
}
