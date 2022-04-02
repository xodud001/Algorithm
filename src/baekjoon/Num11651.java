package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num11651 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<MyPoint2> points = new ArrayList<>();
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            points.add(new MyPoint2(sc.nextInt(), sc.nextInt()));
        }

        points.sort(MyPoint2::compareTo);
        points.forEach(System.out::println);
    }
}

class MyPoint2 implements Comparable<MyPoint2> {
    private final int x;
    private final int y;

    public MyPoint2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public int compareTo(MyPoint2 o) {
        if(this.y == o.y)
            return this.x - o.x;
        else
            return this.y - o.y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
