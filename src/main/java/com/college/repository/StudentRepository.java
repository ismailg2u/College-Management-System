package com.college.repository;

import com.college.entity.Student;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findBySituation(int situation);

    @Modifying
    @Query("UPDATE Student s SET s.situation = 1 WHERE s.id = :studentId AND s.situation = 0")
    void deactivateStudentById(@Param("studentId") int studentId);


}
