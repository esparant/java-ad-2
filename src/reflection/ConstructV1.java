package reflection;

import java.lang.reflect.Constructor;

public class ConstructV1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("reflection.data.BasicData");

        for (Constructor<?> constructor : aClass.getConstructors()) {
            System.out.println("constructor = " + constructor);
        }

        for (Constructor<?> constructor : aClass.getDeclaredConstructors()) {
            System.out.println("constructor = " + constructor);
        }




    }
}
