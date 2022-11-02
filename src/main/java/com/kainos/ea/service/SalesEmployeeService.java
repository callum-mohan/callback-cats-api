package com.kainos.ea.service;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.dao.SalesEmployeeDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.SalesEmployee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SalesEmployeeService {
    Connection connection = dbConnection.getConnection();

    public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
        SalesEmployeeDao dao = new SalesEmployeeDao();

        return dao.selectAllSalesEmployees(connection);
    }

    public SalesEmployee getSalesEmployeeByID(int employeeID) throws SQLException{
        SalesEmployeeDao dao = new SalesEmployeeDao();
        return dao.selectSalesEmployeeByID(employeeID, connection);
    }

    public boolean insertSalesEmployee(SalesEmployee employee) throws SQLException{
        SalesEmployeeDao dao = new SalesEmployeeDao();
        EmployeeDao dao1 = new EmployeeDao();
        dao1.insertEmployee(employee, connection);
        dao.insertSalesEmployee(employee, connection);
        return true;
    }

    public SalesEmployee getHighestSales() throws SQLException {
        SalesEmployeeDao dao = new SalesEmployeeDao();
        return dao.selectHighestSalesTotal(connection);
    }
}
