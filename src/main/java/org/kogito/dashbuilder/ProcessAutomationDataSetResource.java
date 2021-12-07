package org.kogito.dashbuilder;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kogito.dashbuilder.model.DataSet;
import org.kogito.dashbuilder.server.ProcessAutomationServer;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ProcessAutomationDataSetResource {
    
    @Inject
    ProcessAutomationServer pas;
    
    @GET
    @Path("processes")
    public DataSet processes() {
        return pas.processes();
    }
    
    @GET
    @Path("tasks")
    public DataSet tasks() {
        return pas.tasks();
    }
}