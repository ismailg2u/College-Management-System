package com.college.service;

import com.college.entity.Student;
import com.college.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public ArrayList<Student> findAll(){
      return (ArrayList<Student>) studentRepository.findAll();
    }

    public ArrayList<Student> findActiveStudents() {
        return (ArrayList<Student>) studentRepository.findBySituation(0);
    }
    public void  saveStudent(Student student){
        studentRepository.save(student);
    }

    @Transactional
    public void deactivateStudent(int studentId) {
        studentRepository.deactivateStudentById(studentId);
    }
}
