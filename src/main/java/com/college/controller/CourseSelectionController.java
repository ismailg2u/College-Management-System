package com.college.controller;

import com.college.entity.CourseSelection;
import com.college.service.CourseSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/CourseSelectionController")
public class CourseSelectionController {
    @Autowired
    CourseSelectionService courseSelectionService;

    @GetMapping("/getCourseSelection")
    @ResponseBody
    public ArrayList<CourseSelection> getCourseSelection(){
        return courseSelectionService.findAll();
    }

    @GetMapping("/findActiveCourseSelection")
    @ResponseBody
    public ArrayList<CourseSelection> findActiveCourse(){
        return courseSelectionService.findActiveCourseSelections();
    }

    @PutMapping("/deactivateCourseSelection/{id}")
    public ResponseEntity<Void> deactivateCourseSelection(@PathVariable("id") int id){
        courseSelectionService.deactivateCourseSelection(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/saveCourseSelection")
    public ResponseEntity<Void> deactivateCourseSelection(@RequestBody CourseSelection courseSelection){
        courseSelectionService.saveCourseSelection(courseSelection);
        return ResponseEntity.noContent().build();
    }


}
