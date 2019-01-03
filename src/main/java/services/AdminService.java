package services;

import annotations.ConsoleInput;
import annotations.Service;
import annotations.StartMethod;
import services.RunInterface;

@Service
public class AdminService {
    @StartMethod
    public void run(@ConsoleInput(displayMessage = "Enter user data:") String input) {
        System.out.println("Admin servise -> run");
        System.out.println(input);

    }

    public void doNothing() {
        System.out.println("Admin does nothing");
    }



}



