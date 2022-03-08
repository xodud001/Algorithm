package baekjoon;

import java.util.*;

public class Num1920 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> list2 = new ArrayList<>();

        int first = sc.nextInt();
        int[] list1 = new int[first];

        for (int i = 0; i < first ; i++) {
            list1[i] = sc.nextInt();
        }
        int second = sc.nextInt();
        for (int i = 0; i < second ; i++) {
            list2.add(sc.nextInt());
        }

        Arrays.sort(list1);

        for (Integer m : list2) {
            int i = Arrays.binarySearch(list1, m);
            if( i >= 0){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
}
