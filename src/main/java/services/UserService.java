package services;

import annotations.ConsoleInput;
import annotations.Service;
import annotations.StartMethod;

@Service
public class UserService {

    @StartMethod
    public void start(@ConsoleInput(displayMessage = "Enter user data:") String input) {
        System.out.println("UserService -> start()");
        System.out.println(input);
    }
}
