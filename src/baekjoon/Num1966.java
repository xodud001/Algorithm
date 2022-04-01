package baekjoon;

import java.io.*;
import java.util.*;

public class Num1966 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int repeatCount = sc.nextInt();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < repeatCount; i++) {
            int quantity = sc.nextInt();
            int targetIndex = sc.nextInt();

            Printer printer = new Printer();

            for (int j = 0; j < quantity; j++) {
                printer.addDocument(new Document(sc.nextInt(), j == targetIndex));
            }
            while (!printer.isEmpty()) {
                if (printer.isPrintable()) {
                    Document printedDocument = printer.print();
                    if (printedDocument.isTarget()) {
                        result.add(printer.getStack());
                        break;
                    }
                } else {
                    printer.firstToBack();
                }
            }
        }
        result.forEach(System.out::println);
    }
}

class Printer {

    private final Queue<Integer> priorities = new PriorityQueue<>(Comparator.reverseOrder());
    private final Queue<Document> queue = new LinkedList<>();

    private int stack = 0;

    public void addDocument(Document document) {
        queue.add(document);
        priorities.add(document.getPriority());
    }

    public boolean isEmpty() {
        return queue.isEmpty() && priorities.isEmpty();
    }

    public boolean isPrintable() {
        Document document = queue.peek();
        Integer priority = priorities.peek();

        return document != null && priority != null && priority == document.getPriority();
    }

    public void firstToBack() {
        queue.add(queue.remove());
    }

    public Document print() {
        stack++;
        priorities.remove();
        return queue.remove();
    }

    public int getStack() {
        return stack;
    }
}

class Document {

    private int priority;
    private boolean isTarget;

    public Document(int priority, boolean isTarget) {
        this.priority = priority;
        this.isTarget = isTarget;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isTarget() {
        return isTarget;
    }
}
