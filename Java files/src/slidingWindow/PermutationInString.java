package slidingWindow;

import java.util.*;

public class PermutationInString {

    public boolean isPermutation(String s1,String s2){

        // s1 = "ab", s2 = "eidbaooo"
        int prevIndex  = 0;
        Map<Character, Integer> s1Freq = new HashMap<>();

        for(char c : s1.toCharArray()){
            s1Freq.put(c, s1Freq.getOrDefault(c, 0)+1);

        }

        for(int i=0;i<s2.length();i++){
            int count = 0;
            while(s1Freq.containsKey(s1.charAt(i)) && (i - prevIndex) < 1){
                count++;
                if(count == s1.length()){
                    return true;
                }

            }

            prevIndex = i;
        }

        return false;
    }

    public boolean isPermutation2(String s1, String s2){

        int n = s1.length();
        int[] freq = new int[26];

        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i) - 'a']++;
        }

        int m = s2.length();
        int[] freq2 = new int[26];

        for(int r=0;r<s2.length();r++){

            freq2[s2.charAt(r) - 'a']++;
            // window by window
            if(r >= n){
           //    once it reached the specific size of n, we can check window by window of size n.
                freq2[s2.charAt(r - n) - 'a']--;
            }

            if(Arrays.equals(freq2,freq)){
                return true;
            }

        }

        return false;

    }

    public static void main(String[] args){
        String s1 = "ab",s2 = "eidbaooo";
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.isPermutation2(s1,s2));


    }
}
