import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> fGroupAnagram(String[] strs){

        // storing the anagrams in map
        Map<String, List<String>> res = new HashMap<>();

        for(String s : strs){
            // for uniquely storing key into res
            int[] count = new int[26];

            // for uniquely storing key into res
            for(char c : s.toCharArray()){
                count['z' - c]++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(count[i]);

            }

            String key = sb.toString();

            if(!res.containsKey(key)){
                res.put(key, new ArrayList<>());

            }
            res.get(key).add(s);

        }

        return new ArrayList<>(res.values());


    }

    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.fGroupAnagram(strs));

    }
}
