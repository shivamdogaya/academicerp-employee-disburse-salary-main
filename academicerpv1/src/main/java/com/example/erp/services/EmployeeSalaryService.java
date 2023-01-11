package com.example.erp.services;

import com.example.erp.bean.Employee;
import com.example.erp.bean.EmployeeSalary;
import com.example.erp.dao.EmployeeSalaryDAO;
import com.example.erp.dao.impl.EmployeeSalaryDAOImpl;

import java.util.List;

public class EmployeeSalaryService {
    EmployeeSalaryDAO empsaldao = new EmployeeSalaryDAOImpl();

    public boolean addEmployeeSalary(List<EmployeeSalary> empsalary) { return empsaldao.addEmployeeSalary(empsalary); }

    public List<EmployeeSalary> getAlreadyDisbursedSalList() { return empsaldao.getAlreadyDisbursedSalList(); }

    public List<EmployeeSalary> getSalRecords(Integer emp_id){ return empsaldao.getSalRecords(emp_id); }

    public  boolean addSalaryByRecords(EmployeeSalary esal) { return empsaldao.addSalaryByRecords(esal); }

    public boolean modifySalaryByRecord(EmployeeSalary empsal) { return empsaldao.modifySalaryByRecord(empsal);}
}
