package ru.liquibaseDocker.liquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class Controller {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/")
    public String allUsers() {

        Wallet customer = new Wallet();
        UUID uuid = UUID.randomUUID();
        customer.setWalletId(uuid);
        customer.setAmount("kihgkl");

        System.out.println("ok");
        customerRepository.save(customer);
        System.out.println("save");
        System.out.println(customerRepository.findAll());
        return "WORD";
    }
}
