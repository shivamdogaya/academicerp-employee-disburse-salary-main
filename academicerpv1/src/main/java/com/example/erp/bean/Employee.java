package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;


@Entity
public class Employee {
    @Override
    public String toString() {
        return "{" +
                "employee_id=" + getEmployee_id() +
                ", first_name='" + getFirst_name() + '\'' +
                ", last_name='" + getLast_name() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", department='" + getDepartment() +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    @Column(nullable = false)
    private String first_name;

    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeTitle title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeDepartment department;

    @JsonbTransient
    @OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<EmployeeSalary> employeeSalaries;

    public Employee() {
    }

    public Employee(String first_name, String last_name, String email, String password, EmployeeTitle title, EmployeeDepartment department, List<EmployeeSalary> employeeSalaries) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.title = title;
        this.department = department;
        this.employeeSalaries = employeeSalaries;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public EmployeeTitle getTitle() {
        return title;
    }

    public void setTitle(EmployeeTitle title) {
        this.title = title;
    }

    public EmployeeDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EmployeeDepartment department) {
        this.department = department;
    }

    public List<EmployeeSalary> getEmployeeSalaries() {
        return employeeSalaries;
    }

    public void setEmployeeSalaries(List<EmployeeSalary> employeeSalaries) {
        this.employeeSalaries = employeeSalaries;
    }

}
