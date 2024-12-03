package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    // s is string and t is subString
    public String findMinimum(String s, String t){

        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.merge(c,1,Integer::sum);
        }

        int matched = 0;
        int minLen = s.length()+1;
        int left = 0;
        int subStr = 0;

        for(int right = 0;right<s.length();right++){
            char sChar = s.charAt(right);
            if(map.containsKey(sChar)){
                map.put(sChar,map.get(sChar) - 1);

                // only increment match when == 0, not less than 0;
                // if less than 0 means there are multiple occurrences in current window
                if(map.get(sChar) == 0){
                    matched++;

                }
            }

            while(matched == t.length()){
                // window size(right - left + 1)
                if((right - left + 1) < minLen){
                    minLen = right - left + 1;
                    subStr = left;
                }

                // shrinking the window
                char deleted = s.charAt(left++);
                if(map.containsKey(deleted)){
                    if(map.get(deleted) == 0){
                        // decrementing match thus a wanted char deleted in window
                        matched--;
                    }
                    // registering the char as removed in hashmap or window by incrementing +1
                    map.put(deleted, map.get(deleted) + 1);

                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen); // (subStr + minLen) for endWindow size

    }

    public static void main(String[] args){
        String s = "ADOBECODEBANC", t = "ABC";
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.findMinimum(s,t));

    }
}
