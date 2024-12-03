public class PrintRangeString {
    public String fPrint(String s){

        StringBuilder output = new StringBuilder();
        for(int i=0;i<s.length();i++){

            char curr = s.charAt(i);
            if(Character.isLetter(curr)){
                int j = i+1;
                StringBuilder numStr = new StringBuilder();

                while(j<s.length() && Character.isDigit(s.charAt(j))){
                    // appending j position not i position.... note it.
                    numStr.append(s.charAt(j));
                    j++;
                }

                // converting the string into integer
                int count = Integer.parseInt(numStr.toString());

                for(int k=0;k<count;k++){
                    output.append(curr);

                }
                // Move the index to the last digit of the number
                i = j-1;

            }

        }
        return output.toString();
    }

    public static void main(String[] args){
        String s = "a1b4";
        PrintRangeString printRangeString = new PrintRangeString();
        System.out.println(printRangeString.fPrint(s));
    }
}
