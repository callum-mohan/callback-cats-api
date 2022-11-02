package com.kainos.ea.service;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    Connection connection = dbConnection.getConnection();

    public List<Employee> getAllEmployees() throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.selectAllEmployees(connection);
    }

    public Employee getEmployeeById(int EmployeeID) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.selectEmployeeByID(EmployeeID, connection);
    }

    public Boolean insertEmployee(Employee employee) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.insertEmployee(employee, connection);
        return true;
    }

    public List<Employee> getEmployeeGrossPay() throws SQLException{
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getEmployeeGrossPay(connection);
    }

}