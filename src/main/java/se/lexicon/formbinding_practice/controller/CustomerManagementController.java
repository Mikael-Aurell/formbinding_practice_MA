package se.lexicon.formbinding_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import se.lexicon.formbinding_practice.service.CustomerService;

@Controller
public class CustomerManagementController {

    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


}
