package com.student.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
