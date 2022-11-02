package com.kainos.ea.service;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.Employee;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
@Api("Engineering Academy Dropwizard API")
public class EmployeeService {

    Connection connection = com.kainos.ea.db.dbConnection.getConnection();

    public List<Employee> getAllEmployees() throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.selectAllEmployees(connection);
    }

    public Employee getEmployeeById(int EmployeeID) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.selectEmployeeByID(EmployeeID, connection);
    }

}