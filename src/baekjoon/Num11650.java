package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Num11650 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        List<MyPoint1> points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            MyPoint1 point = new MyPoint1(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            points.add(point);
        }

        points.sort(MyPoint1::compareTo);
        for (MyPoint1 point : points)
            bw.write(point.toString() + "\n");

        bw.flush();
    }
}

class MyPoint1 implements Comparable<MyPoint1> {
    int x;
    int y;

    public MyPoint1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(MyPoint1 o) {
        if (this.x - o.x == 0) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

