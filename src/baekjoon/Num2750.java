package baekjoon;

import java.util.*;

public class Num2750 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size = sc.nextInt();

        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        for (int i : a) {
            System.out.println( i);
        }
    }
}
