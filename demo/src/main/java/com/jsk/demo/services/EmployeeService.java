package com.jsk.demo.services;

import com.jsk.demo.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> lstEmployee = new ArrayList<>();

    public void addEmployee(Employee employee){
        lstEmployee.add(employee);
                System.out.println(employee.getNama());
    }

    public List<Employee> getAllEmployee(){
        return lstEmployee ;
    }

}
