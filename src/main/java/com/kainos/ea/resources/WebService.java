package com.kainos.ea.resources;

import com.google.protobuf.Message;

import com.kainos.ea.model.Employee;
import com.mysql.cj.exceptions.NumberOutOfRange;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kainos.ea.db.dbConnection.getConnection;

@Path("/api")
@Api("Engineering Academy Dropwizard API")
public class WebService {

}