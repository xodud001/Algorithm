package test;

import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        //^*N+₩D{0}+F*
        boolean result = Pattern.matches("[A-Z]*N[A-Z]{0,4}F[A-Z]*", "AWNQAWRFSQ");

        System.out.println("result = " + result);
    }
}
