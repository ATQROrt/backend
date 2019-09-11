package com.ort.atqr.Service;

import com.ort.atqr.Exception.UserNotFoundException;
import com.ort.atqr.Model.Student;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentService {

    public Student testLogin(Student student) throws NullPointerException, UserNotFoundException {
        if(student == null || student.getPassword() == null || student.getDocument() == null || student.getPassword().isEmpty()){
            throw new NullPointerException();
        }

        if(student.getPassword().equals("password") && student.getDocument().equals((long)12345678)){
            student.setImageUrl("https://i.imgur.com/W7eohDk.jpg");
            student.setBirth(new Date());
            student.setMail("alumno@alumno.com");
            student.setFirstName("Nombree");
            student.setLastName("APellido");
            return student;
        }

        throw new UserNotFoundException();
    }
}
