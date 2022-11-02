package com.kainos.ea.service;

import com.kainos.ea.dao.DepartmentDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.Department;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    Connection connection = dbConnection.getConnection();
    public List<Department> getAllDepartments() throws SQLException {
        DepartmentDao dao = new DepartmentDao();
        return dao.selectAllDepartments(connection);
    }

    public Department getDepartmentById(int departmentId) throws SQLException{
        DepartmentDao dao = new DepartmentDao();
        return dao.selectDepartmentById(departmentId, connection);
    }

    public boolean insertDepartment(Department department) throws SQLException{
        DepartmentDao dao = new DepartmentDao();
        dao.insertDepartment(department, connection);
        return true;
    }
}
