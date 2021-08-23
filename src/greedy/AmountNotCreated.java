package greedy;

import java.util.Arrays;

public class AmountNotCreated {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,2,1,1,9}));
    }
    public static int solution(int[] coins){
        Arrays.sort(coins);
        int target = 1;

        for (int coin : coins) {
            if(target < coin) break;
            target+=coin;
        }

        return target;
    }
}
