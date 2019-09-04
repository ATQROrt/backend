package com.ort.atqr.Controllers;


import com.ort.atqr.Models.Student;
import com.ort.atqr.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody Student student){
        String result;
        try{
            Student std = studentService.login(student);
            if(std == null){
                result = "Alumno no encontrado";
            } else{
                result = "OK";
            }
        } catch(NullPointerException e){
            result = "Hay datos que faltan";
        } catch (Exception e){
            result = "Ups... Pasaron things";
        }
        return result;
    }
}
