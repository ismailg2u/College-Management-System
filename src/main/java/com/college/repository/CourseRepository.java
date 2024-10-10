package com.college.repository;


import com.college.entity.Course;
import com.college.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findBySituation(int situation);

    @Modifying
    @Query("UPDATE Course t SET t.situation = 1  WHERE t.id = :courseId")
    void deactivateCourseById(@Param("courseId") int courseId);

}
