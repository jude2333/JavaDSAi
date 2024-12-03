public class Anagram {
    public boolean validAnagram(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

        int[] countTotal = new int[26];
        int[] countT = new int[26];

        for(int i=0;i<s.length();i++){

            char charS = s.charAt(i);
            char charT = t.charAt(i);

            countTotal['z' - charS] ++;
            countTotal['z' - charT] --;

            
        }

        for(int i=0;i<26;i++){
            if(countTotal[i] != 0){
                return false;

            }
        }
        return true;

    }

    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";

        Anagram anagram = new Anagram();
        System.out.println(anagram.validAnagram(s,t));
    }
}
