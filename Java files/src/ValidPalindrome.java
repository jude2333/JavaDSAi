public class ValidPalindrome {

    public boolean isValid(String str){

        str = str.toLowerCase();

        int i=0,j=str.length()-1;
        while(i<=j){
            char first = str.charAt(i);
            char last = str.charAt(j);

            if(str.charAt(i) == ' ' || !Character.isLetterOrDigit(first)){
                i++;


            }
            if(str.charAt(j) == ' ' || !Character.isLetterOrDigit(last)){
                j--;
            }

            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }



        return true;
    }

    public static void main(String[] args){

        String s = "malayalam";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isValid(s));
    }
}
