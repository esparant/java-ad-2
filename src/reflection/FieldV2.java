package reflection;

import java.lang.reflect.Field;
import reflection.data.User;

public class FieldV2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id1", "userA", 19);
        System.out.println("name = " + user.getName());

        Class<? extends User> userClass = user.getClass();
        Field nameField = userClass.getDeclaredField("name");

        nameField.setAccessible(true);
        nameField.set(user, "userB");
        System.out.println("changed name = " + user.getName());


    }
}
