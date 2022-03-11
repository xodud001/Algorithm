package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num11651 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        points.sort(Point::compareTo);
        points.forEach(System.out::println);
    }
}

class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
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
