package baekjoon;

import java.io.*;
import java.util.*;

public class Num2751 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < size; i++)
            lists.add(Integer.parseInt(br.readLine()));

        Collections.sort(lists);
        for (Integer item : lists)
            bw.write(item + "\n");
        bw.flush();
    }
}
