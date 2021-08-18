package greedy;

public class MultipleOrPlus {
    public static void main(String[] args) {
        MultipleOrPlus multipleOrPlus = new MultipleOrPlus();
        System.out.println("RESULT : " + multipleOrPlus.solution("567"));
    }

    public int solution(String input){
        int answer = input.charAt(0) == '0' ? 1 : input.charAt(0)-'0';

        System.out.println(answer);
        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) != '0') {
                System.out.println(input.charAt(i)-'0');
                answer *= (input.charAt(i) - '0');
            }
        }

        return answer;
    }
}
