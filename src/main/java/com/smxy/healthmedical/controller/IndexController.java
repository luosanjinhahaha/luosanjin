package com.smxy.healthmedical.controller;

import com.smxy.healthmedical.bean.Department;
import com.smxy.healthmedical.bean.Famous_Doctor;
import com.smxy.healthmedical.service.DeptService;
import com.smxy.healthmedical.service.FamdoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    DeptService deptService;
    @Autowired
    FamdoctorService famdoctorService;
    @GetMapping("/")
    public String index(Model model){
        List<Department> list = deptService.getDepts();
        List<Famous_Doctor> famdoctorlist = famdoctorService.getAll();
        model.addAttribute("dept",list);
        model.addAttribute("famdoctor",famdoctorlist);
        return "frontdesk/homepage";
    }
}
