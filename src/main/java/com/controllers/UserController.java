package com.controllers;


import com.entities.Customer;
import com.services.SecurityService;
import com.hellokoding.account.service.CustomerService;
import com.hellokoding.account.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService CustomerService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CustomerValidator CustomerValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("CustomerForm", new Customer());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("CustomerForm") Customer CustomerForm, BindingResult bindingResult, Model model) {
        CustomerValidator.validate(CustomerForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        CustomerService.save(CustomerForm);

        securityService.autologin(CustomerForm.getCustomername(), CustomerForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your Customer name and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
