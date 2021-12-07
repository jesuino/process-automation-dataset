package org.kogito.dashbuilder.server;

import org.kogito.dashbuilder.model.DataSet;

/**
 * A process automation server. Can be Kogito, Kie Server or any other kind of
 * server.
 * 
 */
public interface ProcessAutomationServer {

    public DataSet processes();

    public DataSet tasks();

    public DataSet runQuery(String query);

}