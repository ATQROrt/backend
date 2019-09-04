package com.ort.atqr.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @PostMapping(value = "/login")
    public String professorLogIn(@RequestBody String professor){
        return "hola";
    }
}
