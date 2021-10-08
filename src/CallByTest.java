
public class CallByTest {
    public static void main(String[] args) {
        User user = new User("user1");
        System.out.println(user);
        user(user);
    }

    public static void user(User user){
        System.out.println(user);
        user = new User("user2");
        System.out.println(user);
    }
}

class User{
    String name;

    public User(String name) {
        this.name = name;
    }
}
