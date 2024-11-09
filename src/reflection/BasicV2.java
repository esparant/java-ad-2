package reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import reflection.data.BasicData;

public class BasicV2 {

    public static void main(String[] args) {
        Class<BasicData> basicData = BasicData.class;

        System.out.println("basicData.getName() = " + basicData.getName());
        System.out.println("basicData.getSimpleName() = " + basicData.getSimpleName());
        System.out.println("basicData.getPackageName() = " + basicData.getPackage());

        System.out.println("basicData.getSuperclass() = " + basicData.getSuperclass());
        System.out.println("basicData.getInterfaces() = " + Arrays.toString(basicData.getInterfaces()));

        System.out.println("basicData.isInterface() = " + basicData.isInterface());
        System.out.println("basicData.isAnnotation() = " + basicData.isAnnotation());

        System.out.println("basicData.getModifiers() = " + basicData.getModifiers());
        System.out.println(
                "Modifier.isPublic(basicData.getModifiers()) = " + Modifier.isPublic(basicData.getModifiers()));
        System.out.println(
                "Modifier.toString(basicData.getModifiers()) = " + Modifier.toString(basicData.getModifiers()));

    }
}
