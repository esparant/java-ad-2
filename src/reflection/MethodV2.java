package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import reflection.data.BasicData;

public class MethodV2 {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BasicData basicData = new BasicData();
        basicData.call(); // static method call

        Class<? extends BasicData> basicDataClass = basicData.getClass();

        Method helloMethod = basicDataClass.getDeclaredMethod("hello", String.class);
        System.out.println("helloMethod.invoke(basicData, \"world\") = " + helloMethod.invoke(basicData, "world"));


    }
}
