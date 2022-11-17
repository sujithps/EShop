package in.upcode.eshop.controller;

import in.upcode.eshop.model.Customer;
import in.upcode.eshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("register")
    public ResponseEntity register(@RequestBody Customer customer) {
        customer.setRole("Admin");
        System.out.println(customerRepository.save(customer));

        return ResponseEntity.ok("Persisted!");
    }
}
