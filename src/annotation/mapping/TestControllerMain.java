package annotation.mapping;

import java.lang.reflect.Method;

public class TestControllerMain {
    public static void main(String[] args) {
        TestController testController = new TestController();

        Class<? extends TestController> aClass = testController.getClass();
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            System.out.println("declaredMethod = " + declaredMethod);
            SimpleMapping annotation = declaredMethod.getAnnotation(SimpleMapping.class);
            if (annotation != null) {
                System.out.println("annotation = " + annotation);
            }
            System.out.println("-------------------------------------");
        }
    }
}
