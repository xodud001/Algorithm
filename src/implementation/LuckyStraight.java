package implementation;

import java.util.ArrayList;
import java.util.List;

public class LuckyStraight {
    public static void main(String[] args) {
        System.out.println(mySolution(123402));
    }

    public static String mySolution(int score){
        List<Integer> numbers = new ArrayList<>();
        int right = 0;
        int left = 0;
        while (score > 0){
            numbers.add(score % 10);
            score = score / 10;
        }
        int middle =numbers.size()/2;

        for(int i = 0 ; i < middle ; i++)
            right += numbers.get(i);

        for(int i = middle ; i < numbers.size() ; i++)
            left += numbers.get(i);

        return right == left ? "LUCKY" : "READY";
    }
}
