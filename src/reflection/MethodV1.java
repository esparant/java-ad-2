package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import reflection.data.BasicData;

public class MethodV1 {
    public static void main(String[] args) {

        Class<BasicData> basicData = BasicData.class;

        for (Method method : basicData.getMethods()) {
            System.out.println("method = " + method);
        }

        System.out.println("===========================================");

        for (Method method : basicData.getDeclaredMethods()) {
            System.out.println("method = " + method);
        }


    }
}
