package com.kainos.ea.controller;

import com.kainos.ea.model.SalesEmployee;
import com.kainos.ea.service.SalesEmployeeService;

import java.sql.SQLException;

public class Sales {
    public SalesEmployee selectHighestSalesEmployee() throws SQLException {
        SalesEmployeeService salesEmployeeService = new SalesEmployeeService();
        return salesEmployeeService.getHighestSales();
    }
}
