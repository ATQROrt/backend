package com.ort.atqr.Service;

import com.ort.atqr.Exception.UserNotFoundException;
import com.ort.atqr.Model.Student;
import com.ort.atqr.Model.User;
import com.ort.atqr.Repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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

    public void createTest() {
        Student myStudent = new Student("Juan", "Perez", 36375564L, "juan.perez@atqr.com", new Date(), "imagen.com", "password");
        studentRepository.save(myStudent);
    }

    public Student login(Student student) {
        if(!validate(student))
            return null;
        return studentRepository.findStudentByDocumentAndPassword(student.getDocument(), student.getPassword());
    }

    public Boolean validate(User user){
        return true;
    }

    public Optional<Student> modify(Student student) {
        Student std = studentRepository.findById(student.getId()).orElse(null);
        if(std != null){
            AttributeHelper.myCopyProperties(student, std);
            studentRepository.save(std);
            return Optional.of(std);
        } else{
            return Optional.empty();
        }
    }
}
