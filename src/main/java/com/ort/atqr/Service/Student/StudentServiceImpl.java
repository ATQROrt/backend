package com.ort.atqr.Service.Student;

import com.ort.atqr.Exception.InvalidInputException;
import com.ort.atqr.Model.Course;
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

    public Optional<Student> updateStudent(Student student) {
        Student std = studentRepository.findById(student.getId()).orElse(null);
        if (std != null) {
            AttributeHelper.myCopyProperties(student, std);
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
        try {
            student.validate();
            return studentRepository.save(student);
        } catch (InvalidInputException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudentFromCourses(id);
        studentRepository.deleteById(id);
    }

    public Optional<List<Student>> getAll() {
        return Optional.ofNullable((List<Student>) studentRepository.findAll());
    }

}
