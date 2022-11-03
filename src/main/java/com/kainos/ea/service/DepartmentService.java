package com.kainos.ea.service;

import com.kainos.ea.dao.DepartmentDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.Department;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    public List<Department> getAllDepartments() throws SQLException {
        DepartmentDao dao = new DepartmentDao();
        return dao.selectAllDepartments(dbConnection.getConnection());
    }

    public Department getDepartmentById(int departmentId) throws SQLException{
        DepartmentDao dao = new DepartmentDao();
        return dao.selectDepartmentById(departmentId, dbConnection.getConnection());
    }

    public boolean insertDepartment(Department department) throws SQLException{
        DepartmentDao dao = new DepartmentDao();
        dao.insertDepartment(department, dbConnection.getConnection());
        return true;
    }

    public List<Integer> getDepartmentId() throws SQLException{
        DepartmentDao dao = new DepartmentDao();
        return dao.getDepartmentId(dbConnection.getConnection());
    }

}
