package annotation.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import util.MyLogger;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnoElement {

    String value();
    int count() default 0;
    String[] tags() default {};

    Class<? extends MyLogger> annoData() default MyLogger.class;
}
