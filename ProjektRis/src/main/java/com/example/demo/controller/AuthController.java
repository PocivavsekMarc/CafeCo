package com.example.demo.controller;

import com.example.demo.model.RegistriranUporabnik;
import com.example.demo.service.RegistriranUporabnikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AuthController {

    private RegistriranUporabnikService registriranUporabnikService;

    public AuthController(RegistriranUporabnikService registriranUporabnikService) {
        this.registriranUporabnikService = registriranUporabnikService;
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        RegistriranUporabnik user = new RegistriranUporabnik();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<RegistriranUporabnik> users = registriranUporabnikService.fetchRegistriranUporabnikList();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") RegistriranUporabnik registriranUporabnik,
                               BindingResult result,
                               Model model){
        RegistriranUporabnik existingUser = registriranUporabnikService.findByEmail(registriranUporabnik.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", registriranUporabnik);
            return "/register";
        }

        registriranUporabnikService.saveRegistriranUporabnik(registriranUporabnik);
        return "redirect:/register?success";
    }
}