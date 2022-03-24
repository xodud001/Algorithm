package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Num1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int depth = Integer.parseInt(br.readLine());

        int[][] arr = new int[depth][depth];
        for (int i = 0; i < depth; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int max = 0;
        for (int i = 0; i < depth; i++) {
            for (int j = 0 ; j <= i ; j++) {
                int left = 0;
                int right = 0;
                try{
                    left = arr[i-1][j-1];
                }catch (Exception ignore){}
                try{
                    right = arr[i-1][j];
                }catch (Exception ignore){}
                arr[i][j] += Integer.max(left, right);
                max = Integer.max(max, arr[i][j]);
            }
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(max);
    }
}
