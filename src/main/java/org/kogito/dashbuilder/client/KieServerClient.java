package org.kogito.dashbuilder.client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.kogito.dashbuilder.model.ks.ProcessInstanceList;
import org.kogito.dashbuilder.model.ks.TaskSummaryList;

@Path("/services/rest/server")
@RegisterClientHeaders(ClientHeaders.class)
public interface KieServerClient {

    @GET
    @Path("queries/processes/instances")
    ProcessInstanceList processes(@QueryParam("status") List<Integer> statuses,
                                  @QueryParam("pageSize") int pageSize);
    
    @GET
    @Path("queries/tasks/instances")
    TaskSummaryList tasks(@QueryParam("pageSize") int pageSize);
    

}
