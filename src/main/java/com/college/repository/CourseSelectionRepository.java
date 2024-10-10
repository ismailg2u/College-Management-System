package com.college.repository;

import com.college.entity.CourseSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CourseSelectionRepository extends JpaRepository<CourseSelection,Integer> {

    List<CourseSelection> findBySituation(int situation);

    @Modifying
    @Query("UPDATE CourseSelection t SET t.situation=1 WHERE t.id = :courseSelectionId")
    void deactivateCourseSelectionById(@Param("courseSelectionId")int courseSelectionId );

}
