package org.kogito.dashbuilder.model.ks;

import java.util.List;

import org.kogito.dashbuilder.model.Column;
import org.kogito.dashbuilder.model.ColumnType;
import org.kogito.dashbuilder.model.DataSet;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProcessInstanceList(@JsonProperty("process-instance") List<ProcessInstance> instances) {

    public DataSet toDataSet() {
        var columns = List.of(new Column("PROCESSINSTANCEID", ColumnType.NUMBER),
                new Column("PROCESSID", ColumnType.LABEL),
                new Column("PROCESSNAME", ColumnType.LABEL),
                new Column("PROCESSVERSION", ColumnType.LABEL),
                new Column("STATUS", ColumnType.NUMBER),
                new Column("CONTAINER", ColumnType.LABEL),
                new Column("USER_IDENTITY", ColumnType.LABEL),
                new Column("START_DATE", ColumnType.DATE),
                new Column("DESCRIPTION", ColumnType.TEXT),
                new Column("CORRELATIONKEY", ColumnType.LABEL),
                new Column("PARENTINSTANCEID", ColumnType.NUMBER),
                new Column("SLACOMPLIANCE", ColumnType.NUMBER)

        );
        var values = new Object[instances.size()][];
        for (int i = 0; i < values.length; i++) {
            var line = instances.get(i);
            values[i] = new Object[]{line.processInstanceId(),
                                     line.processId(),
                                     line.processName(),
                                     line.processVersion(),
                                     line.state(),
                                     line.container(),
                                     line.initiator(),
                                     DateValue.toString(line.startDate()),
                                     line.description(),
                                     line.correlationKey(),
                                     line.parentInstanceId(),
                                     line.slaCompliance()};
        }

        return new DataSet(columns, values);
    }

}
