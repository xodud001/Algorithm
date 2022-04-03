package baekjoon;

import java.io.*;
import java.util.*;

public class Num1181 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int repeat = Integer.parseInt(br.readLine());
        Set<Word> set = new HashSet<>(repeat);
        for (int i = 0; i < repeat; i++)
            set.add(new Word(br.readLine()));


        List<Word> list = new ArrayList<>(set);
        list.sort(Word::compareTo);
        for (Word word : list) {
            bw.write(word.toString()+"\n");
        }
        bw.flush();
    }

    static class Word implements Comparable<Word>{
        private final String value;

        public Word(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(Word o) {
            int lengthCompare = Integer.compare(this.value.length(), o.value.length());
            if(lengthCompare == 0){
                return value.compareTo(o.value);
            }else{
                return lengthCompare;
            }
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return Objects.equals(value, word.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
