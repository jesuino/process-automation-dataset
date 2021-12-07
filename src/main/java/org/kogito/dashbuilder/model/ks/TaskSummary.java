package org.kogito.dashbuilder.model.ks;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TaskSummary(@JsonProperty("task-id") long id,
                          @JsonProperty("task-name") String name,
                          @JsonProperty("task-subject") String subject,
                          @JsonProperty("task-description") String description,
                          @JsonProperty("task-status") String status,
                          @JsonProperty("task-priority") int priority,
                          @JsonProperty("task-is-skipable") boolean isSkippable,
                          @JsonProperty("task-actual-owner") String actualOwner,
                          @JsonProperty("task-created-by") String createdBy,
                          @JsonProperty("task-created-on") DateValue createdOn,
                          @JsonProperty("task-activation-time") DateValue activationTime,
                          @JsonProperty("task-expiration-time") DateValue expirationTime,
                          @JsonProperty("task-proc-inst-id") long processInstanceId,
                          @JsonProperty("task-proc-def-id") String processId,
                          @JsonProperty("task-container-id") String containerId,
                          @JsonProperty("task-parent-id") long parentId,
                          @JsonProperty("correlation-key") String correlationKey) {

}