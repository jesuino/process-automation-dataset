# Process Automation DataSet

This project is aimed to create Process Automation datasets for Dashbuilder. It can connect to Kie Server or Kogito to retrieve process data and transform in an unified interface that can be consumed by Dashbuilder.

## Configuration

To create datasets you must use system properties to tell 


connection.type=(KOGITO|KIESERVER)
connection.user={username}
connection.credentials={password}
connection.url={target service base URL}
k
With this you have the following datasets endpoints ready to be consumed by DashBuilder:

* `/processes`: Return all the process instances information
* `/tasks`: Return all human tasks

You can later register custom queries using system properties

queries.{query name}.query={Kie Server or Kogito Data Index query}

Then you can run this query with the result as dataset using the endpoint `/query/{query name}`.



