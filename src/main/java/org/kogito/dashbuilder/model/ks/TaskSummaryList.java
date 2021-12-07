package org.kogito.dashbuilder.model.ks;

import java.util.List;

import org.kogito.dashbuilder.model.Column;
import org.kogito.dashbuilder.model.ColumnType;
import org.kogito.dashbuilder.model.DataSet;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TaskSummaryList(@JsonProperty("task-summary") List<TaskSummary> tasks) {

    public DataSet toDataSet() {
        var columns = List.of(new Column("ID", ColumnType.NUMBER),
                new Column("NAME", ColumnType.LABEL),
                new Column("SUBJECT", ColumnType.LABEL),
                new Column("DESCRIPTION", ColumnType.TEXT),
                new Column("PRIORITY", ColumnType.NUMBER),
                new Column("IS_SKIPABLE", ColumnType.LABEL),
                new Column("ACTUAL_OWNER", ColumnType.LABEL),
                new Column("CREATED_BY", ColumnType.LABEL),
                new Column("CREATED_ON", ColumnType.DATE),
                new Column("PROCESSINSTANCEID", ColumnType.NUMBER),
                new Column("PROCESSID", ColumnType.LABEL),
                new Column("CONTAINER", ColumnType.LABEL),
                new Column("STATUS", ColumnType.LABEL),
                new Column("CORRELATION_KEY", ColumnType.LABEL)

        );
        var values = new Object[tasks.size()][];
        for (int i = 0; i < values.length; i++) {
            var line = tasks.get(i);

            values[i] = new Object[]{line.id(),
                                     line.name(),
                                     line.subject(),
                                     line.description(),
                                     line.priority(),
                                     line.isSkippable(),
                                     line.actualOwner(),
                                     line.createdBy(),
                                     DateValue.toString(line.createdOn()),
                                     line.processInstanceId(),
                                     line.processId(),
                                     line.containerId(),
                                     line.status(),
                                     line.correlationKey()};
        }

        return new DataSet(columns, values);
    }

}
