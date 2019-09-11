package com.ort.atqr.Services;

import com.ort.atqr.Model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student login(Student student) throws NullPointerException {
        if(student.getPassword() == null || student.getDocument() == null || student.getPassword().isEmpty()){
            throw new NullPointerException();
        }

        return null;
    }
}
