package com.example.springdemo.Controller;

import com.example.springdemo.Dao.PersonDao;
import com.example.springdemo.Entity.Person;
import com.example.springdemo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class PostPageController {
    @GetMapping(value="/")
    public  String postPage(Person person){
        return "formPage";
    }
    @Autowired
    PersonService personService;
    @PostMapping(value = "/result")
    public String postInfo(@Valid Person person, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "formPage";
        }
        model.addAttribute("name",person.getName());
        model.addAttribute("email",person.getEmail());
        model.addAttribute("telephone",person.getTelephone());
        personService.add(person.getName(),person.getTelephone(),person.getEmail());
        return "result";
    }
    @GetMapping(value = "/index")
    public String blogPage(){
        return "index";
    }
}
