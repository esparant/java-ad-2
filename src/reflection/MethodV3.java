package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import reflection.data.Calculator;

public class MethodV3 {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("call method: ");
        String methodName = scanner.nextLine();

        System.out.print("number 1: ");
        int number1 = scanner.nextInt();
        System.out.print("number 2: ");
        int number2 = scanner.nextInt();

        Calculator calculator = new Calculator();

        Class<? extends Calculator> calculatorClass = calculator.getClass();
        Method method = calculatorClass.getMethod(methodName, int.class, int.class);

        Object answer = method.invoke(calculator, number1, number2);
        System.out.println("answer = " + answer);


    }
}
