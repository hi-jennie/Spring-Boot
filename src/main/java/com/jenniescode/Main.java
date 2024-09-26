package com.jenniescode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class Main {
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    record NewCustomerRequest(Integer age, String name, String email) {}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setAge(request.age());
        customer.setName(request.name());
        customer.setEmail(request.email());
        customerRepository.save(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }



    /*
    @GetMapping("/greeting")
    public GreetResponse greeting() {
        GreetResponse greet = new GreetResponse("Hello World", List.of("Java", "Python"), new Person("Jennie", 25, 1000.0));
        return greet;
    }

    record Person(String name, int age, double savings) {}
    record GreetResponse(String message, List<String> favoriteLang, Person person) {}

    // this is the same as the record class above

    public static class GreetResponse {
        private final String message;

        public GreetResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

     */
}
