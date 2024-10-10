package com.college.service;

import com.college.entity.Define;
import com.college.repository.DefineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DefineService {


    @Autowired
    DefineRepository defineRepository;

    public ArrayList<Define> findAll(){
        return (ArrayList<Define>) defineRepository.findAll();
    }



}
