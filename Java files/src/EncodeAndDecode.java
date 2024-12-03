import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {

    public static String Encode(List<String> strs){

        StringBuilder sb  = new StringBuilder();
        for(String s : strs){
            int Length = s.length();
            sb.append(s);
            sb.append(Length);
            sb.append("#");

        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static List<String> decode(String args){
        int i = 0;
        int j = 0;
        List<String> res = new ArrayList<>();
        while(j<args.length()){
            if('#' == args.charAt(j)){
                res.add(args.substring(i,j-1));
                i = j+1;
                j = i;
            }
            j++;
        }
        System.out.println(res.toString());
        return res;
    }
     public static void main(String[] args){

        List<String> str = new ArrayList<>();
        str.add("jude");
        str.add("shello");

//        Encode(str);
        decode(Encode(str));
     }
}
