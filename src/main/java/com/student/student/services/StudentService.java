package com.student.student.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student.dao.StudentRepository;
import com.student.student.entity.Student;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        Student oldStudent = null;
        if (optionalStudent.isPresent()) {
            oldStudent = optionalStudent.get();
            oldStudent.setName(student.getName());
            oldStudent.setRoll(student.getRoll());
            oldStudent.setStndrd(student.getStndrd());
            oldStudent.setSection(student.getSection());
            studentRepository.save(oldStudent);
        } else
            return new Student();
        return oldStudent;
    }

    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "Student deleted";
    }
}
