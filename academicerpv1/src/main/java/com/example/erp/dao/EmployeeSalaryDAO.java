package com.example.erp.dao;

import com.example.erp.bean.EmployeeSalary;

import java.util.List;

public interface EmployeeSalaryDAO {
    public boolean addEmployeeSalary(List<EmployeeSalary> employee_salary);

    public List<EmployeeSalary> getAlreadyDisbursedSalList();

    public List<EmployeeSalary> getSalRecords(Integer emp_id);

    public boolean addSalaryByRecords(EmployeeSalary emp_sal);

    boolean modifySalaryByRecord(EmployeeSalary emp_sal);
}
