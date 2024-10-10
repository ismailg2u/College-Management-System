package com.college.repository;

import com.college.entity.DefineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefineTypeRepository extends JpaRepository<DefineType,Integer> {

}
