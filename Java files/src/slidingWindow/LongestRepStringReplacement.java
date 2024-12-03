package slidingWindow;

public class LongestRepStringReplacement {

    public int longest(String s, int k){

        int maxFreq = 0, l = 0,res = 0;
        int[] count = new int[26];

        for(int r=0;r<s.length();r++){
            count[s.charAt(r) - 'A']++;     // s = "AABABBA"
            // maxFreq assigning when updating the window char freq
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);
            // in the sameLoop we will not update maxFreq at while because the result will not change
            // the result wil change when maxFreq increases.
            // but then in the next for loop the maxFreq will change based on the current window freq.
            while((r-l+1) - maxFreq > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r-l+1);

        }
        return res;
    }

    public static void main(String[] args){
        LongestRepStringReplacement longestStringReplacement = new LongestRepStringReplacement();
        String  s = "AABCKK";
        int k = 1;
        System.out.println(longestStringReplacement.longest(s, k));

    }

}
