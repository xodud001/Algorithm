package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class AdventurerGuild {
    public static void main(String[] args) {
        int[] input = {2, 3, 1, 2, 2};
        AdventurerGuild a = new AdventurerGuild();

        System.out.println(a.solution(input));
    }

    public int solution(int[] users){
        int answer = 0;
        Arrays.sort(users);
        int i = users.length-1;
        while (i >= 0){
            i -= users[i];
            if(i >= -1 ) answer++;
        }
        return answer;
    }
}
