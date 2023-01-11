package com.example.erp.controller;

import com.example.erp.bean.Employee;
import com.example.erp.bean.EmployeeSalary;
import com.example.erp.services.EmployeeSalaryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("/employee-salary")
public class EmployeeSalaryController {
    EmployeeSalaryService employeeService = new EmployeeSalaryService();

    @POST
    @Path("/addSalary")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginEmployee(List<EmployeeSalary> empSal) throws URISyntaxException {
        if(employeeService.addEmployeeSalary(empSal)) {
            return Response.status(200).build();
        }
        else {
            return Response.status(203).build();
        }
    }


    @GET
    @Path("/alreadyDisbursedSalary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlreadyDisbursedSal() throws URISyntaxException {
        System.out.println("getting hit");
        List<EmployeeSalary> empSal = employeeService.getAlreadyDisbursedSalList();;
        return Response.ok().entity(empSal).build();
    }


    @POST
    @Path("/getSalaryRecords")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEmployees(Employee employee) {
        List<EmployeeSalary> salList = employeeService.getSalRecords(Integer.parseInt(String.valueOf(employee.getEmployee_id())));

        return Response.ok().entity(salList).build();
    }


    @POST
    @Path("/addSalaryByRecord")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSalaryByRecords(EmployeeSalary empSal) throws URISyntaxException {
        if(employeeService.addSalaryByRecords(empSal)) {
            return Response.status(200).build();
        }
        else {
            return Response.status(203).build();
        }
    }

    @POST
    @Path("/modifySalaryByRecord")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifySalaryByRecord(EmployeeSalary empSal) throws URISyntaxException {
        System.out.println(employeeService.modifySalaryByRecord(empSal));
        if(employeeService.modifySalaryByRecord(empSal)) {
            return Response.status(200).build();
        }
        else {
            return Response.status(203).build();
        }
    }

}
