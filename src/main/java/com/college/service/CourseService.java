package com.college.service;

import com.college.entity.Course;
import com.college.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public ArrayList<Course> findAll(){
        return (ArrayList<Course>) courseRepository.findAll();
    }

    public ArrayList<Course> findActiveCourses(){
        return (ArrayList<Course>) courseRepository.findBySituation(0);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public void deactivateCourse(int courseId){
        courseRepository.deactivateCourseById(courseId);
    }
}
