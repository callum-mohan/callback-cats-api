package com.kainos.ea.service;

import com.kainos.ea.dao.DeliveryEmployeeDao;
import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.DeliveryEmployee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeliveryEmployeeService {
    Connection connection = dbConnection.getConnection();
    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException {
        DeliveryEmployeeDao dao = new DeliveryEmployeeDao();
        return dao.selectAllDeliveryEmployees(connection);
    }

    public DeliveryEmployee getDeliveryEmployeeByID(int employeeID) throws SQLException{
        DeliveryEmployeeDao dao = new DeliveryEmployeeDao();
        return dao.selectDeliveryEmployeeByID(employeeID, connection);
    }

    public boolean insertDeliveryEmployee(DeliveryEmployee emp) throws SQLException{
        EmployeeDao dao = new EmployeeDao();
        DeliveryEmployeeDao dao1 = new DeliveryEmployeeDao();
        dao.insertEmployee(emp, connection);
        dao1.insertDeliveryEmployee(emp, connection);
        return true;
    }
}
