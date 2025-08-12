# Query Stage SDK

This public Github repository provides resources to help developers build their own Fusion Query stage plugins. 
The resources include documentation on how to use the SDK, as well as an example plugin implementation:

* [Query Stage Plugin SDK](query-stage-plugin-sdk/README.adoc) - Query Stage SDK library. It contains 
  classes and interfaces necessary for building new query plugin stages. Documentation can be found in both the README and javadocs.
* [Example Plugin Stage](examples/sample-plugin-stage/README.adoc) - contains an example of how a plugin can be  implemented as well as information on how to build and deploy the plugin.

# Fusion Version

The Query Stage SDK is available for use starting in Fusion 5.4

# Fusion DSL

The Query Stage SDK can only be used with the Fusion DSL. 




# Compatibility matrix

Both, Fusion and the implemented plugin need to use the same version of the Query Stage SDK.

The following table shows the compatibility matrix for the Query Stage SDK and Fusion versions:


| Fusion Version     | Query Stage SDK Version | Compile plugin with JDK Version |
|--------------------|-------------------------|---------------------------------|
| 5.4  -  5.9.14     | 1.0.0                   | 8                               |
| 5.9.15             | 2.0.0                   | 11                              |


Make sure to use the correct version of the Query Stage SDK and JDK when building your plugin to ensure compatibility with the Fusion version you are using.
