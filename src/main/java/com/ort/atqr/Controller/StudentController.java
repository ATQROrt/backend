package com.ort.atqr.Controller;


import com.ort.atqr.Exception.UserNotFoundException;
import com.ort.atqr.Model.Response;
import com.ort.atqr.Model.Student;
import com.ort.atqr.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping(value = "/login")
    public ResponseEntity<Student> login(@RequestBody Student student){
        Student logged = studentService.login(student);

        return new ResponseEntity<>(logged, HttpStatus.OK);

    }

    @PostMapping(value = "/testlogin")
    public Response testlogin(@RequestBody Student student){
        String message = "";
        int code = 500;
        Object object = null;
        try{
            object = studentService.testLogin(student);
        } catch(NullPointerException e){
            message = "Hay datos que faltan";
            code = 400;
        } catch (UserNotFoundException e){
            message = "El usuario no fue encontrado";
            code = 404;
        } catch (Exception e){
            message = "Ups... Pasaron things";
        }
        return new Response(object, message, code);
    }

    @GetMapping(value = "/createtest")
    public ResponseEntity createTest(){
        ResponseEntity resp = new ResponseEntity(HttpStatus.CREATED);
        studentService.createTest();
        return resp;
    }
}
