package reflection;

import reflection.data.Team;
import reflection.data.User;

public class FieldV3 {

    public static void main(String[] args) throws IllegalAccessException {

        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("user = " + user);
        System.out.println("team = " + team);

        // CHANGE string is null -> "" , Integer is null -> 0
        // ** USE REFLECTION

        FieldUtil.nullFieldToDefault(user);
        FieldUtil.nullFieldToDefault(team);

        System.out.println("user = " + user);
        System.out.println("team = " + team);

    }
}
