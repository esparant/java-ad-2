package reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import reflection.data.BasicData;

public class FieldV1 {
    public static void main(String[] args) {
        Class<BasicData> basicDataClass = BasicData.class;

        for (Field field : basicDataClass.getFields()) {
            System.out.println("field = " + field);
        }

        for (Field field : basicDataClass.getDeclaredFields()) {
            System.out.println("field = " + field);
        }


    }
}
