package com.college.service;


import com.college.entity.CourseSelection;
import com.college.repository.CourseSelectionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseSelectionService {

    @Autowired
    CourseSelectionRepository courseSelectionRepository;


    public ArrayList<CourseSelection> findAll(){
        return (ArrayList<CourseSelection>) courseSelectionRepository.findAll();
    }

    public ArrayList<CourseSelection> findActiveCourseSelections(){
        return (ArrayList<CourseSelection>) courseSelectionRepository.findBySituation(0);
    }

    public void saveCourseSelection(CourseSelection courseSelection){
        courseSelectionRepository.save(courseSelection);
    }

    @Transactional
    public void deactivateCourseSelection(int courseSelectionId){
        courseSelectionRepository.deactivateCourseSelectionById(courseSelectionId);
    }


}
