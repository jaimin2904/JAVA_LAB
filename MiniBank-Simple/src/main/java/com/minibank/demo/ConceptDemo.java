package com.minibank.demo;
import com.minibank.model.*;
import com.minibank.service.TransactionProcessor;
import com.minibank.util.*;
public class ConceptDemo {
    public static void main(String[] args) throws Exception {
        Account[] examples = { new SavingsAccount("Riya", 5000), new CurrentAccount("Aman", 3000), new FixedDepositAccount("Neha", 8000) };
        for (Account account : examples) System.out.println(account.getOwnerName() + " interest: " + account.interestRate());
        System.out.println("Is Account: " + (examples[0] instanceof Account));
        System.out.println("Mobile valid: " + Validator.isValidMobile("9876543210"));
        System.out.println("Command: " + CommandParser.parse("DEPOSIT AC0001 500"));
        Customer customer = new Customer("Riya", "riya@example.com", "9876543210", new Customer.Address("Main Road", "Rajkot", "360001"));
        System.out.println("Customer: " + customer.getCustomerId() + " / cloned: " + customer.clone().getName());
        System.out.println("Annotation check: " + AnnotationValidator.isValid(examples[0]));
        Repository<Account> repository = new Repository<>();
        repository.saveAll(examples);
        System.out.println("Repository count: " + repository.findAll().size());
        Integer[] numbers = {10, 20, 30};
        System.out.println("Average: " + Repository.average(numbers));
        TransactionProcessor processor = new TransactionProcessor();
        processor.submit(() -> System.out.println("Simple background task completed"));
        processor.stop();
    }
}
