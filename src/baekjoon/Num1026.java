package baekjoon;

import java.util.*;

public class Num1026 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int length = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < length; i++) {
            b.add(sc.nextInt());
        }

        a.sort(Collections.reverseOrder());
        b.sort(Integer::compareTo);
        int result = s(a, b);
        System.out.println(result);

    }
    public static int s(List<Integer> a, List<Integer> b){
        int result = 0;
        for(int i = 0 ; i < a.size()  ; i++){
            result += a.get(i) * b.get(i);
        }
        return result;
    }
}
