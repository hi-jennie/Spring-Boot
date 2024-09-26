package com.jenniescode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/greeting")
    public GreetResponse greeting() {
        GreetResponse greet = new GreetResponse("Hello World", List.of("Java", "Python"), new Person("Jennie", 25, 1000.0));
        return greet;
    }

    record Person(String name, int age, double savings) {}
    record GreetResponse(String message, List<String> favoriteLang, Person person) {}

    // this is the same as the record class above
//    public static class GreetResponse {
//        private final String message;
//
//        public GreetResponse(String message) {
//            this.message = message;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//    }
}
