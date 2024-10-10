package com.college.controller;


import com.college.entity.Course;
import com.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/CourseController")
public class CourseController {
    @Autowired
    CourseService courseService;


    @GetMapping("/getCourse")
    @ResponseBody
    public ArrayList<Course> getCourse(){
        return courseService.findAll();
    }

    @PostMapping("/saveCourse")
    public ResponseEntity<Void> saveCourse(@RequestBody Course course){
        courseService.saveCourse(course);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getActiveCourse")
    @ResponseBody
    public ArrayList<Course> findActiveCourse(){
        return courseService.findActiveCourses();
    }

    @PutMapping("/deactivateCourse/{id}")
    public ResponseEntity<Void> deactivateCourse(@PathVariable("id") int id){
        courseService.deactivateCourse(id);
        return ResponseEntity.noContent().build();
    }
}
