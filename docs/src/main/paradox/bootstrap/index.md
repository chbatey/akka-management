<a id="bootstrap"></a>
# Akka Cluster Bootstrap

The bootstrap module allows an Akka Cluster to its neighbouring nodes,
and join the existing cluster, or safely form a new cluster for discovered nodes. It is an alternative to configuring  
static `seed-nodes`.

The bootstrap processes may be configured to use various implementations of how to discover other nodes. One
implementation utilises DNS records and this works particularity well in environments like Kubernetes or Mesos
where DNS records are managed for Services automatically.

Akka Cluster Bootstrap not require any additional system like etcd/zookeeper/consul to be run along side the Akka cluster in order to discover the seed-nodes.

## Prerequisites

Bootstrap depends on:

 * @ref:[Akka Discovery](../discovery/index.md)
 * @ref:[Akka Management](../akka-management.md) 
 
  It is recommended to understand these before trying to use bootstrap.

## Dependency

Add `akka-management-cluster-bootstrap` and one or more discovery mechanisms `akka-discovery` 
implementation you'd like to use for the discovery process. 

For example, you might choose to use the DNS discovery and bootstrap extensions:

sbt
:   @@@vars
    ```scala
    libraryDependencies += "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap" % "$version$"
    libraryDependencies += "com.lightbend.akka.discovery" %% "akka-discovery-dns"                % "$version$"
    ```
    @@@

Maven
:   @@@vars
    ```xml
    <dependency>
      <groupId>com.lightbend.akka.management</groupId>
      <artifactId>akka-management-cluster-bootstrap_$scala.binaryVersion$</artifactId>
      <version>$version$</version>
    </dependency>
    <dependency>
      <groupId>com.lightbend.akka.discovery</groupId>
      <artifactId>akka-discovery-dns_$scala.binaryVersion$</artifactId>
      <version>$version$</version>
    </dependency>
    ```
    @@@

Gradle
:   @@@vars
    ```gradle
    dependencies {
      compile group: "com.lightbend.akka.management", name: "akka-management-cluster-bootstrap_$scala.binaryVersion$", version: "$version$"
      compile group: "com.lightbend.akka.discovery", name: "akka-discovery-dns_$scala.binaryVersion$", version: "$version$"
    }
    ```
    @@@



## Using 

* Akka management must be started to use bootstrap as it adds endpoints that are served by management:

Scala
:   ```scala
    AkkaManagement(system).start()
    ```

Java
:   ```java
    AkkaManagement.get(system).start();
    ```
    
* Remove `seed-nodes` from configuration if present.

* Start Bootstrap on every node:





