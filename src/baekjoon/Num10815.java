package baekjoon;

import java.util.*;

public class Num10815 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Integer> ns = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ns.add(sc.nextInt());
        }
        int m = sc.nextInt();
        List<Integer> ms = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            ms.add(sc.nextInt());
        }

        ns.sort(Integer::compareTo);
        for (Integer item : ms) {
            int result = Collections.binarySearch(ns, item);
            System.out.print((result >= 0 ? 1 : 0) + " ");
        }
    }
}
