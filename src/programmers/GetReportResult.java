package programmers;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class GetReportResult {

    public static void main(String[] args) {
        String[] ids = {"muzi", "frodo", "apeach", "neo"};
        String[] reports = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] results = solution(ids, reports, k);
        System.out.println(Arrays.toString(results));
    }

    public static int[] solution(String[] id_list, String[] reportList, int k) {
        Users users = new Users(id_list);
        ReportHandler reportHandler = new ReportHandler(users);

        List<ReportContext> reports = ReportContext.of(reportList);

        for (ReportContext context : reports)
            reportHandler.handle(context);


        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            User user = users.get(id_list[i]);
            answer[i] = user.getMailCount(k);
        }
        return answer;
    }
}

class User{
    private final String name;
    private final Set<User> reportUsers = new HashSet<>();
    private int reportCount = 0;

    public int getReportCount() {
        return reportCount;
    }

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void report(User user){
        reportUsers.add(user);
        user.reported();
    }

    public void reported(){
        reportCount++;
    }

    public int getMailCount(int k){
        int result = 0;
        for (User reportUser : reportUsers)
            if(reportUser.getReportCount() >= k)
                result++;

        return result;
    }
}

class Users{

    private final Map<String, User> users;

    public Users(String[] users) {
        this.users = Arrays.stream(users)
                .map(User::new)
                .collect(toMap(User::getName, Function.identity()));
    }

    public User get(String name){
        return users.get(name);
    }

}

class ReportContext {
    private final String caller;
    private final String receiver;

    public ReportContext(String caller, String receiver) {
        this.caller = caller;
        this.receiver = receiver;
    }

    public String getCaller() {
        return caller;
    }

    public String getReceiver() {
        return receiver;
    }

    public static List<ReportContext> of(String[] report){
        return Arrays.stream(report)
                .distinct()
                .map(r -> {
                    String caller = r.split(" ")[0];
                    String receiver = r.split(" ")[1];
                    return new ReportContext(caller, receiver);
                })
                .collect(toList());
    }
}

class ReportHandler{

    private final Users users;

    public ReportHandler(Users users) {
        this.users = users;
    }

    public void handle(ReportContext context){
        User caller = users.get(context.getCaller());
        User receiver = users.get(context.getReceiver());
        caller.report(receiver);
    }
}

