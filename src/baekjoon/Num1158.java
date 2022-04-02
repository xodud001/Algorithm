package baekjoon;

import java.util.*;

public class Num1158 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();

        int people = sc.nextInt();
        int index = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < people; i++)
            queue.add(i);

        int stack = 1;
        while (!queue.isEmpty()) {
            if(stack == index){
                result.add(queue.remove()+1);
                stack = 1;
            }else{
                stack++;
                queue.add(queue.remove());
            }
        }

        System.out.println(print(result));
    }

    public static String print(List<Integer> list){
        StringBuilder builder = new StringBuilder();
        builder.append("<");
        for (int i = 0; i < list.size()-1; i++) {
            builder.append(list.get(i) + ", ");
        }
        builder.append(list.get(list.size() - 1));
        builder.append(">");
        return builder.toString();
    }
}
