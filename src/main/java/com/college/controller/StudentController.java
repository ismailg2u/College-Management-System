package com.college.controller;


import com.college.entity.Student;
import com.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/StudentController")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudent")
    @ResponseBody
    public ArrayList<Student> getStudent(){
        return studentService.findAll();
    }

    @GetMapping("/getActiveStudent")
    public List<Student> getActiveStudents() {
        return studentService.findActiveStudents(); // Fetch and return the students
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Void> saveStudent(@RequestBody     Student student){
        studentService.saveStudent(student);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/deactivate/{id}") // Use PUT for updates
    public ResponseEntity<Void> deactivateStudent(@PathVariable("id") int id) {
        studentService.deactivateStudent(id); // Call the service method
        return ResponseEntity.noContent().build(); // Return 204 No Content response
    }
}
