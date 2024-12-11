package binarySearch.practise;

import Arrays.Anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public List<List<String>> isAnagram(String[] strs ){

        Map<String, List<String>> anagrams = new HashMap<>();

        for(String s : strs) {
            int[] charToOrds = new int[26];

            for (int i = 0; i < s.length(); i++) {
                charToOrds['z' - s.charAt(i)]++;
                System.out.println('z' - s.charAt(i));

            }

            String key = charToOrds.toString();


                anagrams.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);

        }


        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        GroupAnagram anagram = new GroupAnagram();
        System.out.println(anagram.isAnagram(strs));
    }


}
