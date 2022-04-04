package programmers;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 단체사진 {

    private static final char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    private static List<String> results;
    private static List<Condition> conditions;

    public static void main(String[] args) {
        int size = solution(2, new String[]{"N~F=0", "R~T>2"});
//        int size = solution(2, new String[]{"M~C<2", "C~M>1"});
        System.out.println("size = " + size);
    }

    public static int solution(int n, String[] data) {
        results = new ArrayList<>();
        conditions = new ArrayList<>();
        for (String datum : data)
            conditions.add(new Condition(datum));

        permutation(friends, 0, friends.length, 8);

        return results.size();
    }

    public static void permutation(char[] arr, int depth, int n, int r) {
        if (depth == r) {
            save(arr, r);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public static void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static void save(char[] arr, int r){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < r; i++) {
            builder.append(arr[i]);
        }

        if(matches(builder.toString())){
            results.add(builder.toString());
        }
    }

    public static boolean matches(String str){
        for (Condition condition : conditions) {
            if(!condition.isMatch(str)) return false;
        }
        return true;
    }
}


class Condition{
    private final Pattern pattern;

    public Condition(String data) {
        char friend1 = data.charAt(0);
        char friend2 = data.charAt(2);
        char symbol = data.charAt(3);
        int size = data.charAt(4) - '0';

        if(symbol == '=') {
            this.pattern = Pattern.compile(String.format("[A-Z]*[%c%c][A-Z]{%d}[%c%c][A-Z]*", friend1,friend2, size ,friend1,friend2));
        }else if(symbol == '>'){
            this.pattern = Pattern.compile(String.format("[A-Z]*[%c%c][A-Z]{%d,%d}[%c%c][A-Z]*", friend1, friend2, size+1, 6 ,friend1 ,friend2));
        }else{ // <
            this.pattern = Pattern.compile(String.format("[A-Z]*[%c%c][A-Z]{%d,%d}[%c%c][A-Z]*", friend1,friend2, 0, size-1, friend1, friend2));
        }
    }

    public boolean isMatch(String str){
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}