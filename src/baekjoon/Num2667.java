package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Num2667 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size = sc.nextInt();

        int[][] map = createMap(size);

        int total = 0;
        List<Integer> sizes = new ArrayList<>();


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int result = search(map, i, j);
                if(result > 0){
                    total++;
                    sizes.add(result);
                }
            }
        }
        sizes.sort(Integer::compareTo);

        System.out.println(total);
        sizes.forEach(System.out::println);
    }

    private static int[][] createMap(int size) {
        int[][] map = new int[size][size];

        for (int i = 0; i < size ; i++) {
            String line = sc.next();
            for (int j = 0; j < line.toCharArray().length; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        return map;
    }

    private static int search(int[][] map, int x, int y){
        int point = 0;


        try{
            if(map[x][y] == 0) return point;

            if(map[x][y] == 1)
            point++;
            map[x][y] = 0;
        }catch (IndexOutOfBoundsException e){
            return point;
        }

        point += search(map, x-1, y); // 위
        point += search(map, x+1, y); // 아래
        point += search(map, x, y-1); // 좌
        point += search(map, x, y+1); // 우

        return point;
    }

}
