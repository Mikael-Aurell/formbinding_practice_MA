package se.lexicon.formbinding_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

    /*@GetMapping("/")
    String showList(){
        return "/customerList";
    }

    @GetMapping("/showForm")
    String showCustomerForm(){
        return "/addCustomerForm";
    }

    @PostMapping("/addCustomer")
    String addCustomerToDatabase(){
        return "redirect:/Customer/";
    }*/
}
