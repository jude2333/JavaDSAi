public class HCFnumber {
    public int hcf(int a, int b){
        if(b == 0){
            return a;

        }

        return hcf(b, a%b);
    }

    public static void main(String[] args){
        int a = 15;
        int b = 10;

        HCFnumber hcFnumber = new HCFnumber();

        System.out.println(hcFnumber.hcf(a,b));

    }
}
