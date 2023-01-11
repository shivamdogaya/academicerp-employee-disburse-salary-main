package com.example.erp.dao.impl;

import com.example.erp.bean.EmployeeSalary;
import com.example.erp.dao.EmployeeSalaryDAO;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;




public class EmployeeSalaryDAOImpl implements EmployeeSalaryDAO {

    @Override
    public boolean addEmployeeSalary(List<EmployeeSalary> employee_salary) {
        Session session = SessionUtil.getSession();
        try
        {
            session.beginTransaction();
            for(EmployeeSalary sal: employee_salary) {
                sal.setPayment_date(Date.valueOf(LocalDate.now()));
                sal.setType('D');
                session.save(sal);
            }
            session.getTransaction().commit();
            session.close();

            return true;
        }
        catch (HibernateException e){
            e.printStackTrace();

            return false;
        }
    }

    @Override
    public List<EmployeeSalary> getAlreadyDisbursedSalList() {
        Session session=SessionUtil.getSession();
        try {
            Query query=session.createQuery("from EmployeeSalary where type='D'");
            return query.getResultList();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
    }

    public List<EmployeeSalary> getSalRecords(Integer emp_id){
        Session session=SessionUtil.getSession();
        try {
            Query query=session.createQuery("from EmployeeSalary where employee.employee_id=:emp_id and type='R' order by date(payment_date) desc");
            System.out.println("hello");
            query.setParameter("emp_id",emp_id);

            return query.getResultList();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
    }

    public boolean addSalaryByRecords(EmployeeSalary emp_sal){
        Session session = SessionUtil.getSession();
        try
        {
            session.beginTransaction();
            System.out.println(emp_sal.getId());
            Query q=session.createQuery("update EmployeeSalary set type=:type , payment_date=current_date() where id=:i");
            q.setParameter("type",'D');
            q.setParameter("i", emp_sal.getId());

            int status=q.executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(status>=1)
                return true;
            else
                return false;
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean modifySalaryByRecord(EmployeeSalary empsal) {
        Session session = SessionUtil.getSession();
        try
        {
            session.beginTransaction();
            Query q=session.createQuery("update EmployeeSalary set amount=:amt where id=:i");
            System.out.println(empsal.getAmount());
            System.out.println(empsal.getId());
            q.setParameter("amt",empsal.getAmount());
            q.setParameter("i",empsal.getId());

            int status=q.executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(status>=1)
                return true;
            else
                return false;
        }
        catch(HibernateException e){
            e.printStackTrace();
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

}


