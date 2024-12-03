package stack;

import java.security.KeyPair;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Histogram {
    public int calcHistogram(int[] heights){

        Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        int area = 0 , n = heights.length;
        int index, height;

        for (int i = 0; i < heights.length; i++) {
            int curHT = heights[i];
            int start = i;

            while (!stack.isEmpty() && stack.peek().getValue() > curHT) {

                Pair<Integer, Integer> pair = stack.pop();
                index = pair.getKey();
                height = pair.getValue();
                // updating area after popping
                area = Math.max(area, height * (i - index));
                // for reverse calc height
                start = index;

            }
            // the start index will be the pair of currentHeight
            // because the left value are larger right , it can be also reverse calculated(r to l)
            stack.push(new Pair<>(start, curHT));
        }

        // left to right calc
            while(!stack.isEmpty()){
                Pair<Integer, Integer> pair = stack.pop();
                index = pair.getKey();
                height = pair.getValue();
                // calculating from left to right remaining
                area = Math.max(area, height * (n - height));

            }

            return area;

        }

        public static void main(String[] args){
            int[] heights = {2,1,5,6,2,3};
            Histogram histogram = new Histogram();
            System.out.println(histogram.calcHistogram(heights));
        }



    }

