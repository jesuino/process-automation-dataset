package org.kogito.dashbuilder.model.ks;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProcessInstance(@JsonProperty("process-instance-id") long processInstanceId,
                              @JsonProperty("process-id") String processId,
                              @JsonProperty("process-name") String processName,
                              @JsonProperty("process-version") String processVersion,
                              @JsonProperty("process-instance-state") int state,
                              @JsonProperty("container-id") String container,
                              @JsonProperty("initiator") String initiator,
                              @JsonProperty("start-date") DateValue startDate,
                              @JsonProperty("process-instance-desc") String description,
                              @JsonProperty("correlation-key") String correlationKey,
                              @JsonProperty("parent-instance-id") long parentInstanceId,
                              @JsonProperty("sla-compliance") int slaCompliance) {

}