package com.kainos.ea.resources;

import com.kainos.ea.controller.HR;
import com.kainos.ea.controller.Sales;
import com.kainos.ea.controller.Talent;
import com.kainos.ea.model.*;
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
    public Response getAllEmps() throws SQLException {
        HR h = new HR();
        List<Employee> result = h.getAllEmployees();
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
    public Response getHighSales() throws SQLException {
        Sales h = new Sales();
        SalesEmployee result = h.selectHighestSalesEmployee();
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
    public Response insertEmployee(SalesEmployee employee) {
        HR h = new HR();
        Boolean result = h.insertEmployee(employee);
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

    @POST
    @Path("/talent/assign/employee={eid}+project={pid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignProject(@PathParam("eid") int employeeID, @PathParam("pid") int projectID) {
        Talent h = new Talent();
        Boolean result = h.addEmployeeToProject(projectID, employeeID);
        Message message = new Message("The employee was successfully assigned to the project.");
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

    @GET
    @Path("/talent/projects")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects() {
        Talent h = new Talent();
        List<Project> result = h.getAllProjects();
        if (result.size() == 0) {
            Message message = new Message("No projects were found!");
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
    @Path("/talent/project-team-size/project={pid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewTeamSize(@PathParam("pid") int projectID) {
        Talent h = new Talent();
        int result = h.getNoOfEmployeesByProject(projectID);
        return Response
                .status(200)
                .entity(result)
                .build();
    }

    @GET
    @Path("/talent/unassigned-employees")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewUnassignedEmployees() {
        Talent h = new Talent();
        List<Employee> result = h.getEmployeesNoProjects();
        return Response
                .status(200)
                .entity(result)
                .build();
    }

    @GET
    @Path("/talent/unassigned-projects")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewUnassignedProjects() {
        Talent h = new Talent();
        List<Project> result = h.getProjectsNoEmployees();
        if (result.size() == 0) {
            Message message = new Message("No projects with no assigned employees were found.");
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
    @Path("/department/ids")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentIDs() {
        HR h = new HR();
        List<Integer> result = h.getDepartmentId();
        if (result.size() == 0) {
            Message message = new Message("No department IDs were found.");
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
    @Path("/department/get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDepartments() throws SQLException {
        HR h = new HR();
        List<Department> result = h.getAllDepartments();
        if (result.size() == 0) {
            Message message = new Message("No departments were found.");
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

    @POST
    @Path("/department/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertDepartment(Department dep) {
        HR h = new HR();
        Boolean result = h.insertDepartment(dep);
        Message message = new Message("The department was successfully added to the database.");
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



