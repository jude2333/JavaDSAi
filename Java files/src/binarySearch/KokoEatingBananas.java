package binarySearch;

import java.util.Arrays;


// time comp ==> O(piles * log(k))
public class KokoEatingBananas {
    public int eatingSpeed(int[] piles, int h){

        int l = 1, r = Arrays.stream(piles).max().getAsInt(); // here r will be not more than any pile
        int res = 1;

        while(l <= r){
            int k = (l + r) / 2; // bananas eaten

            int totalTime = 0;
            for(int p : piles){
                totalTime += Math.ceil((double) p/k); // for hours
            }

            if(totalTime <= h){
                res = k;
                r = k - 1;

            }else{
                l = k + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        System.out.println(kokoEatingBananas.eatingSpeed(piles, h));
    }

}
