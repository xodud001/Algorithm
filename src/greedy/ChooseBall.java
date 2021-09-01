package greedy;

public class ChooseBall {
    public static void main(String[] args) {
        int[] balls = {1, 5, 4, 3, 2, 4, 5, 2};

        System.out.println("My Solution : " + mySolution(balls));
        System.out.println("Book Solution : " + bookSolution(balls));
    }

    public static int mySolution(int[] balls){
        int count = 0;
        for(int i = 0 ; i < balls.length - 1 ; i++){
            for(int j = i+1 ; j < balls.length ; j++){
                if(balls[i] != balls[j]) count++;
            }
        }
        return count;
    }

    public static int bookSolution(int[] balls){
        int n = balls.length;
        int count = 0;
        int[] ballsWeight = new int[11];

        for (int ball : balls)
            ballsWeight[ball] += 1;

        for (int weight : ballsWeight) {
            n -= weight;
            count += weight * n;
        }
        return count;
    }
}
