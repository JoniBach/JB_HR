package com.test.project01.controller;

import com.test.project01.repository.EmployeeJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewEmployeeController {
        private final EmployeeJDBC employeeJDBC;

        @Autowired
        public ViewEmployeeController(EmployeeJDBC employeeJDBC) {
                this.employeeJDBC = employeeJDBC;
        }

        @GetMapping("/view_employees")
        public String user_display(@RequestParam(name ="id" , required = false, defaultValue = "1")int id, Model model){

                model.addAttribute("employee",employeeJDBC.findAll());
                return "view_employees";
        }


}