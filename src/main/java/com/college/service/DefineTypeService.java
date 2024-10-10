package com.college.service;

import com.college.entity.DefineType;
import com.college.repository.DefineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DefineTypeService {

    @Autowired
    DefineTypeRepository defineTypeRepository;

    public ArrayList<DefineType> findAll(){
        return (ArrayList<DefineType>) defineTypeRepository.findAll();
    }


}
