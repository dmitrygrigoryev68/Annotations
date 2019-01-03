import annotations.ConsoleInput;
import annotations.Service;
import annotations.StartMethod;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;
import java.util.Set;


public class App {
    @SneakyThrows
    public static void main(String[] args) {

        Reflections reflections = new Reflections("services");
        Set<Class<?>> services = reflections.getTypesAnnotatedWith(Service.class);

        services.forEach(System.out::println);

        for (Class<?> clazz : services) {
            Object serviceInstance = clazz.newInstance();
            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                if (!method.isAnnotationPresent(StartMethod.class)) {
                    continue;
                }

                Parameter[] parameters = method.getParameters();
                String input = null;
                for (Parameter parameter : parameters) {
                    if (parameter.isAnnotationPresent(ConsoleInput.class) && parameter.getType().equals(String.class)) {
                        ConsoleInput consoleInput = parameter.getAnnotation(ConsoleInput.class);
                        System.out.println(consoleInput.displayMessage());
                        Scanner scanner = new Scanner(System.in);
                        input = scanner.nextLine();
                    }

                    System.out.println(parameter.isAnnotationPresent(ConsoleInput.class));
                }
                //           method.invoke(serviceInstance);
                //System.out.println(method);

            }
        }
    }
}
