package com.jsk.demo.controllers;


import com.jsk.demo.models.Employee;
import com.jsk.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;



@Controller
public class TestController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/my-request")
    public String myRequestResponse(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
       model.addAttribute(  "fromServer", 233);
       model.addAttribute("attribute2", "my name is bayu" );
        List<String> myList = new ArrayList<>();
       myList.add("bayu");
        myList.add("aji");
        myList.add("pras");
        model.addAttribute("namanama",myList);
        return "view";
    }
    @GetMapping("/show-employeeform")
    public String showfrom  (Model model ){
        model.addAttribute("employee",new Employee());
                return "employeeform";}

    @PostMapping("/do-save-employee")
            public String doSave(@ModelAttribute ("employee") Employee emp){
        employeeService.addEmployee(emp);
        return"employeeform";
        }

    @GetMapping("/show-employee")
    public String getAllemployee (Model model) {
        model.addAttribute("fromEmployee", employeeService.getAllEmployee());
        return"employees";

    }
}

