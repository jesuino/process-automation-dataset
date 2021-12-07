package org.kogito.dashbuilder.server.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.kogito.dashbuilder.client.KieServerClient;
import org.kogito.dashbuilder.model.DataSet;
import org.kogito.dashbuilder.server.ProcessAutomationServer;

@ApplicationScoped
public class KSProcessAutomationServer implements ProcessAutomationServer {

    @Inject
    KieServerClient kieServerClient;

    @Override
    public DataSet processes() {
        return kieServerClient.processes(List.of(1, 2, 3),
                -1).toDataSet();
    }

    @Override
    public DataSet tasks() {
        return kieServerClient.tasks(-1).toDataSet();
    }

    @Override
    public DataSet runQuery(String query) {
        return null;
    }

}
