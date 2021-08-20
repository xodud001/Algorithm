package greedy;

public class ReverseString {

    public static void main(String[] args) {
        String s = "100011001100101";
        ReverseString r = new ReverseString();
        System.out.println(r.solution(s));
    }

    public int solution(String s){
        int zero = 0;
        int one = 0;

        boolean zeroOrOne = s.charAt(0) == '0'; // 0 : true, 1 : false
        boolean pre;
        for(int i = 1 ; i < s.length() ; i++){
            pre = zeroOrOne;
            zeroOrOne = s.charAt(i) == '0';
            if(pre && !zeroOrOne) zero++;
            else if(!pre && zeroOrOne) one++;
        }
        if(zeroOrOne) zero++;
        else one++;
        return Math.max(zero, one);
    }

}
