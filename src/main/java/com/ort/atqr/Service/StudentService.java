package com.ort.atqr.Service;

import com.ort.atqr.Exception.ErrorMessage;
import com.ort.atqr.Exception.UserNotFoundException;
import com.ort.atqr.Model.Student;
import com.ort.atqr.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
        return studentRepository.findStudentByDocumentAndPassword(student.getDocument(), student.getPassword());
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

    public Student createNewStudent(Student student) throws IllegalArgumentException{
        validateStudentFields(student);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    private void validateStudentFields(Student student){
        if(student.getFirstName() == null || student.getFirstName().isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_NAME_EMPTY);
        }

        if(student.getLastName() == null || student.getLastName().isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_LAST_NAME_EMPTY);
        }

        if(student.getDocument() == null || student.getDocument() < 1){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_INVALID_DOCUMENT);
        }

        if(student.getBirth() == null || student.getBirth().before(new Date(111900)) || student.getBirth().after(new Date())){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_INVALID_BIRTHDATE);
        }

        if(student.getMail() == null){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_INVALID_MAIL);
        }

        if(student.getPassword() == null || student.getPassword().length() < 8 || student.getPassword().length() > 16){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_INVALID_PASSWORD);
        }
    }

    public Optional<List<Student>> getAll() {
        return Optional.ofNullable((List<Student>) studentRepository.findAll());
    }
}
