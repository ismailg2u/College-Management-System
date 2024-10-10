package com.college.controller;


import com.college.entity.Define;
import com.college.service.DefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/DefineController")
public class DefineController {

    @Autowired
    DefineService defineService;

    @GetMapping("/getDefine")
    @ResponseBody
    public ArrayList<Define> getDefine(){
        return defineService.findAll();
    }
}

