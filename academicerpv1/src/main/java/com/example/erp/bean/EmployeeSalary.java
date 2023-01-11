package com.example.erp.bean;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Check(constraints = "amount >= 0")
public class EmployeeSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date payment_date;

    @Column(nullable = false)
    private double amount;

    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    char type; //'R'=Request and 'D'=Disburse

    public EmployeeSalary(){
    }

    public EmployeeSalary(Integer id, Employee employee, Date payment_date, double amount, String description) {
        this.payment_date = payment_date;
        this.amount = amount;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EmployeeSalary{" +
                "id=" + id +
                ", payment_date=" + payment_date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
