package baekjoon;

import java.io.*;
import java.util.*;

public class Num10828 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCount = Integer.parseInt(br.readLine());
        List<String> lines = new ArrayList<>();
        CustomStack customStack = new CustomStack(bw);

        for (int i = 0; i < commandCount; i++)
            lines.add(br.readLine());

        for (String line : lines)
            customStack.handle(line);

        bw.flush();
    }
}

class CustomStack{
    private final Stack<Integer> stack = new Stack<>();
    private final BufferedWriter bw;

    public CustomStack(BufferedWriter bw) {
        this.bw = bw;
    }

    public void handle(String line) throws IOException {
        CommandContext context = CommandContext.of(line);

        if (context.getCommand() == Command.PUSH) {
            push(context);
        }else if(context.getCommand() == Command.POP){
            pop();
        }else if(context.getCommand() == Command.SIZE){
            size();
        }else if(context.getCommand() == Command.EMPTY){
            isEmpty();
        }else if(context.getCommand() == Command.TOP){
            top();
        }else{
            throw new UnsupportedOperationException("지원되지 않는 명령어입니다.");
        }
    }

    private void push(CommandContext context){
        stack.push(context.getValue());
    }

    private void pop() throws IOException {
        if(stack.size() == 0)
            bw.write(-1+"\n");
        else
            bw.write(stack.pop()+"\n");

    }

    private void size() throws IOException {
        bw.write(stack.size()+"\n");
    }

    private void isEmpty() throws IOException {
        bw.write( (stack.isEmpty() ? 1 : 0) +"\n");
    }

    private void top() throws IOException {
        if(stack.size() == 0)
            bw.write(-1+"\n");
        else
            bw.write(stack.peek()+"\n");
    }
}

class CommandContext {
    private final Command command;
    private final int value;

    public CommandContext(String command, int value) {
        this.command = Command.valueOf(command.toUpperCase(Locale.ROOT));
        this.value = value;
    }

    public static CommandContext of(String line) {
        String[] tokens = line.split(" ");
        if (tokens.length == 2) {
            return new CommandContext(tokens[0], Integer.parseInt(tokens[1]));
        } else {
            return new CommandContext(tokens[0], 0);
        }
    }

    public Command getCommand() {
        return command;
    }

    public int getValue() {
        return value;
    }

}

enum Command{
    PUSH,
    POP,
    SIZE,
    EMPTY,
    TOP
}


