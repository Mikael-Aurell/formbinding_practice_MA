package se.lexicon.formbinding_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.formbinding_practice.dto.CustomerDto;
import se.lexicon.formbinding_practice.entity.Customer;
import se.lexicon.formbinding_practice.service.CustomerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/CustomerManagement")
public class CustomerManagementController {

    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/showList")
    public String getAll(Model model){
        model.addAttribute("customerDtoList", customerService.getAll());
        return "customerManagement";
    }

    @GetMapping("/find/{customerId}")
    public String getCustomerById(@PathVariable("customerId") String customerId, Model model){
        System.out.println("customerId = " + customerId);
        CustomerDto customerDto = customerService.findByCustomerId(customerId);
        model.addAttribute("customerDto", customerDto);
        return "customerDetails";
    }

    @GetMapping("/showCustomerForm")
    public String registerForm(Model model){
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto", customerDto);
        return "addCustomerForm";
    }

    @PostMapping("/addToDatabase")
    public String addCustomerToDatabase(@Valid
            @ModelAttribute("customerDto") CustomerDto customerDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "addCustomerForm";
        }
        customerService.saveOrUpdate(customerDto);
        redirectAttributes.addFlashAttribute("messages", "Add customer email: " + customerDto.getEmail() +"is done.");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/customerManagement/showList";
    }
}
