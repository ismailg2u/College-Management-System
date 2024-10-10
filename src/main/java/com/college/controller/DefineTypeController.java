package com.college.controller;


import com.college.entity.Define;
import com.college.entity.DefineType;
import com.college.service.DefineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/DefineTypeController")
public class DefineTypeController {
    @Autowired
    DefineTypeService defineTypeService;

    @GetMapping("/getDefineType")
    @ResponseBody
    public ArrayList<DefineType> getDefineType(){
        return defineTypeService.findAll();
    }
}
