package greedy;

public class ChooseBall {
    public static void main(String[] args) {
        int[] balls = {1, 5, 4, 3, 2, 4, 5, 2};
        int count = 0;

        for(int i = 0 ; i < balls.length - 1 ; i++){
            for(int j = i+1 ; j < balls.length ; j++){
                if(balls[i] != balls[j]) count++;
            }
        }
        System.out.println(count);
    }
}
