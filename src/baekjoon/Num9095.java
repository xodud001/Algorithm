package baekjoon;

import java.io.*;

public class Num9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int[] result = new int[12];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for(int i = 4 ; i < result.length ; i++){
            for(int j = i-3 ; j < i ; j++){
                result[i] += result[j];
            }
        }

        int count = Integer.parseInt(br.readLine());
        int[] sizes = new int[count];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = Integer.parseInt(br.readLine());
        }

        for (int size : sizes) {
            bw.write(result[size]+"\n");
        }
        bw.flush();
    }
}
