package com.college.service;

import com.college.entity.Teacher;
import com.college.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public ArrayList<Teacher> findAll(){
        return (ArrayList<Teacher>) teacherRepository.findAll();
    }


    public ArrayList<Teacher> findActiveTeachers(){
        return (ArrayList<Teacher>) teacherRepository.findBySituation(0);
    }

    public void saveTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    @Transactional
    public void deactivateTeacherById(int teacherId){
        teacherRepository.deactivateTeacherById(teacherId);
    }
}
