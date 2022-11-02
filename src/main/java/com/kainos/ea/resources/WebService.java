package com.kainos.ea.resources;

import com.kainos.ea.controller.HR;
import com.kainos.ea.controller.Sales;
import com.kainos.ea.controller.Talent;
import com.kainos.ea.model.DeliveryEmployee;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.Project;
import com.kainos.ea.model.SalesEmployee;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/api")
@Api("Business System API")
public class WebService {
    public WebService() {
    }

    @GET
    @Path("/employees/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmps() {
        HR h = new HR();
        List<Employee> result = h.getAllEmployees();
        if (result.size() == 0) {
            Message message = new Message("No employees were found.");
            return Response
                    .status(204)
                    .entity(message)
                    .build();
        }
        return Response
                .status(200)
                .entity(result)
                .build();
    }

    @GET
    @Path("/employees/get/type=Delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmps() {
        HR h = new HR();
        List<DeliveryEmployee> result = h.getAllDeliveryEmployees();
        if (result.size() == 0) {
            Message message = new Message("No delivery employees were found.");
            return Response
                    .status(204)
                    .entity(message)
                    .build();
        }
        return Response
                .status(200)
                .entity(result)
                .build();
    }

    @GET
    @Path("/employees/get/type=Sales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmps() {
        HR h = new HR();
        List<SalesEmployee> result = h.getAllSalesEmployees();
        if (result.size() == 0) {
            Message message = new Message("No sales employees were found.");
            return Response
                    .status(204)
                    .entity(message)
                    .build();
        }
        return Response
                .status(200)
                .entity(result)
                .build();
    }

    @GET
    @Path("/employees/highestSales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHighSales() {
        Sales h = new Sales();
        SalesEmployee result;
        try {
            result = h.selectHighestSalesEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
            Message message = new Message("There was a problem processing your request, try again later.");
            return Response
                    .status(500)
                    .entity(message)
                    .build();
        }
        return Response
                .status(200)
                .entity(result)
                .build();
    }

    @POST
    @Path("/employees/add/type=Employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertEmployee(Employee e) {
        HR h = new HR();
        Boolean result = h.insertEmployee(e);
        Message message = new Message("The employee was successfully added to the database.");
        if (result) {
            return Response
                    .status(201)
                    .entity(message)
                    .build();
        } else {
            message.setText("There was a problem processing your request, try again later.");
            return Response
                    .status(500)
                    .entity(message)
                    .build();
        }
    }

    @POST
    @Path("/employees/add/type=Delivery")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertEmployee(DeliveryEmployee e) {
        HR h = new HR();
        Boolean result = h.insertEmployee(e);
        Message message = new Message("The employee was successfully added to the database.");
        if (result) {
            return Response
                    .status(201)
                    .entity(message)
                    .build();
        } else {
            message.setText("There was a problem processing your request, try again later.");
            return Response
                    .status(500)
                    .entity(message)
                    .build();
        }
    }

    @POST
    @Path("/employees/add/type=Sales")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertEmployee(SalesEmployee e) {
        HR h = new HR();
        Boolean result = h.insertEmployee(e);
        Message message = new Message("The employee was successfully added to the database.");
        if (result) {
            return Response
                    .status(201)
                    .entity(message)
                    .build();
        } else {
            message.setText("There was a problem processing your request, try again later.");
            return Response
                    .status(500)
                    .entity(message)
                    .build();
        }
    }

    @POST
    @Path("/projects/add/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertProject(Project p) {
        Talent h = new Talent();
        Boolean result = h.insertProject(p);
        Message message = new Message("The project was successfully added to the database.");
        if (result) {
            return Response
                    .status(201)
                    .entity(message)
                    .build();
        } else {
            message.setText("There was a problem processing your request, try again later.");
            return Response
                    .status(500)
                    .entity(message)
                    .build();
        }
    }
}



