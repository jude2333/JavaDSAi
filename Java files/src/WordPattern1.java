import java.util.HashMap;
import java.util.Map;

public class WordPattern1 {
    public boolean wordpattern(String pattern, String s){
        String[] words = s.split(" ");
        Map<Character, String> charToString = new HashMap<>();
        Map<String, Character> StringToChar = new HashMap<>();

        for(int i=0;i<pattern.length();i++){

            if (charToString.containsKey(pattern.charAt(i)) && !charToString.get(pattern.charAt(i)).equals( words[i])){
                return false;

            }
            if (StringToChar.containsKey(words[i]) && !StringToChar.get(words[i]).equals(pattern.charAt(i))){
                return false;

            }
            charToString.put(pattern.charAt(i), words[i]);
            StringToChar.put(words[i], pattern.charAt(i));


        }
        return true;

        }
    public static void main(String[] args){
        String s = "dog cat cat dog";
        String pattern = "abba";
        WordPattern1 wordPattern1 = new WordPattern1();
        System.out.println(wordPattern1.wordpattern(pattern, s));

        }
    }

