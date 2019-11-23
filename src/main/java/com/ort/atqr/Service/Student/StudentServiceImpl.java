package com.ort.atqr.Service.Student;

import com.ort.atqr.Exception.InvalidInputException;
import com.ort.atqr.Model.Course;
import com.ort.atqr.Model.Professor;
import com.ort.atqr.Model.Student;
import com.ort.atqr.Repository.StudentRepository;
import com.ort.atqr.Service.AttributeHelper;
import com.ort.atqr.Service.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> login(Student student) {
        return Optional.ofNullable(studentRepository.findStudentByDocumentAndPassword(student.getDocument(), student.getPassword()));
    }

    private void validate(Student student){
        try{
            student.validate();
        } catch(InvalidInputException e){
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Optional<Student> updateStudent(Student student) {
        Student std = studentRepository.findById(student.getId()).orElse(null);
        if (std != null) {
            AttributeHelper.myCopyProperties(student, std);
            validate(std);
            studentRepository.save(std);
            return Optional.of(std);
        } else {
            return Optional.empty();
        }
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createNewStudent(Student student) {
        validate(student);
        studentRepository.findStudentByDocumentOrMail(student.getDocument(), student.getMail()).ifPresent(x ->
        {throw new IllegalArgumentException("Ya existe un alumno con este mail o documento");});
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudentFromCourses(id);
        List<Long> assistanceIds = studentRepository.findAssistanceId(id);
        for(Long aid : assistanceIds){
            studentRepository.deleteAssistance(aid);
        }
        studentRepository.deleteStudentFromAssistance(id);
        studentRepository.deleteById(id);
    }

    public Optional<List<Student>> getAll() {
        return Optional.ofNullable((List<Student>) studentRepository.findAll());
    }

}
