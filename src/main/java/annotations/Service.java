package annotations;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Service {
}
