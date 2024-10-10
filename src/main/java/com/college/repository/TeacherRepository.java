package com.college.repository;

import com.college.entity.Teacher;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    List<Teacher> findBySituation(int situation);

    @Modifying
    @Query("UPDATE Teacher t SET t.situation = 1  WHERE t.id = :teacherId")
    void deactivateTeacherById(@Param("teacherId") int teacherId);
}
