package org.kogito.dashbuilder.model;

import java.util.List;

public record DataSet(List<Column> columns, Object[][] values) {
    
    
}