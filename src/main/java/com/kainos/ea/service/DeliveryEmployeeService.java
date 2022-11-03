package com.kainos.ea.service;

import com.kainos.ea.dao.DeliveryEmployeeDao;
import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.DeliveryEmployee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeliveryEmployeeService {
    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException {
        DeliveryEmployeeDao dao = new DeliveryEmployeeDao();
        return dao.selectAllDeliveryEmployees(dbConnection.getConnection());
    }

    public DeliveryEmployee getDeliveryEmployeeByID(int employeeID) throws SQLException{
        DeliveryEmployeeDao dao = new DeliveryEmployeeDao();
        return dao.selectDeliveryEmployeeByID(employeeID, dbConnection.getConnection());
    }

    public boolean insertDeliveryEmployee(DeliveryEmployee emp) throws SQLException{
        EmployeeDao dao = new EmployeeDao();
        DeliveryEmployeeDao dao1 = new DeliveryEmployeeDao();
        dao.insertEmployee(emp, dbConnection.getConnection());
        dao1.insertDeliveryEmployee(dao.lastInsertID(dbConnection.getConnection()), emp, dbConnection.getConnection());
        return true;
    }
}
