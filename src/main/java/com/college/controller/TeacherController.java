package com.college.controller;

import com.college.entity.Teacher;
import com.college.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/TeacherController")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/getTeacher")
    @ResponseBody
    public ArrayList<Teacher> getTeacher(){
        return teacherService.findAll();
    }

    @GetMapping("/getActiveTeacher")
    @ResponseBody
    public ArrayList<Teacher> getActiveTeacher(){return teacherService.findActiveTeachers();}

    @PostMapping("/saveTeacher")
    public ResponseEntity<Void> saveTeacher(@RequestBody Teacher teacher){
        teacherService.saveTeacher(teacher);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/deactivateTeacher/{id}")
     public ResponseEntity<Void> deactivateTeacher(@PathVariable("id") int id){
        teacherService.deactivateTeacherById(id);
        return ResponseEntity.noContent().build();
    }


}
