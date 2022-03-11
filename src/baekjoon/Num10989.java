package baekjoon;

import java.io.*;

public class Num10989 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        int[] lists = new int[10000];
        for (int i = 0; i < size; i++) {
            lists[Integer.parseInt(br.readLine())-1]++;
        }

        for(int i = 0 ; i < lists.length ; i++){
            int now = lists[i];
            if(now == 0) continue;
            for(int j = 0 ; j < now ; j++){
                builder.append(i+1).append("\n");
            }
        }
        System.out.println(builder);
    }
}
