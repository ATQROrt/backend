package com.ort.atqr;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Router {

    @PostMapping(value = "logIn/test")
    public String professorLogIn(@RequestBody String professor){
        return "hola";
    }
}
