package Social;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App extends Users{

    private static Map<String, Users> DataBase = new HashMap<>();

    public App(String userName, List following, List posts) {
        super(userName, following, posts);
    }

    public static List<String> createArray() {
        List<String> following = new ArrayList<>();

        following.add("IsmaElSanguijuela");
        following.add("Alejandra");

        return following;
    }

    public static void printElements(List<String> customList) {
        for (String element : customList) {
            System.out.println(element);
        }
    }

    public static void initialUsers() {
        Users u1 = new Users("BraisVarela", following);
    }




}
