package slidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestStringWithoutRepeat {

    public int longWithoutRep(String str){

        Set<Character> set = new HashSet<>();
        int right=0,left=0,max=0;
        while(right < str.length()){
            char c = str.charAt(right);
            while(set.contains(c)){
                set.remove(str.charAt(left));
                left++;

            }
//            System.out.println(left);
            set.add(c);
            max = Math.max(max,right-left+1); // right - left + 1 is for correct length calculation
            right++;
        }

        return max;
    }

    public int longestWithoutRep2(String strs){

        List<Character> list = new ArrayList<>();
        int largestLength = 0;

        for(int i=0;i<strs.length();i++){
            if(list.contains(strs.charAt(i))){
                int index = list.indexOf(strs.charAt(i));
//                list.remove(index);
                list.subList(0, index+1).clear();

                // str = peiwwkeo
//
//                if(i > 0){
//                    list.subList(0, index).clear();
//                }
            }

            list.add(strs.charAt(i));
            largestLength = Math.max(largestLength, list.size());

        }
        return largestLength;

    }

    public static void main(String[] args){
        String s = "pwwkei";
        LongestStringWithoutRepeat longestStringWithoutRepeat = new LongestStringWithoutRepeat();
        //System.out.println(longestStringWithoutRepeat.longWithoutRep(s));
        System.out.println(longestStringWithoutRepeat.longestWithoutRep2(s));
    }
}
