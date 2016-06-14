HornetQ -> JMS -> HTTP using OpenShift Enterprise and Camel Boot
=======================================

This project demonstrates consumption of JMS messages from HornetQ, persiting them to A-MQ then forwarding them over HTTP to an Endpoint.

The Camel routes used in this example are explained by the following diagram:

![Flow Diagram](img/flow.png)

Setup
==============================

You should probably set up the basic developer tools to be able to go through these steps, examples. We will also cover more ideal workflows with developer-local setup of docker and openshift, so would be good to install the "optional" tools as well!

- Install JBoss Developer Studio 9.1.0 GA [https://www.jboss.org/products/devstudio.html]
- Install Apache Maven 3.2.x [http://maven.apache.org]
- Install JBoss Fuse  6.2.1 [https://www.jboss.org/products/fuse.html]

Java Build & Run
==============================

### Build this project

> <project home> $ mvn clean install

## Running locally
Startup Fuse in the background so that we have a local A-MQ broker running.  Via the command-line, you should be able to run this project locally using mvn, and it should work as expected:

>  mvn camel:run

## Running on JBoss Fuse
You will need to install this example first:
  
> mvn install

Install Derby database and JDBC connection pool in Fuse with:

> osgi:install -s mvn:commons-pool/commons-pool/1.6

> osgi:install -s mvn:commons-dbcp/commons-dbcp/1.4

> osgi:install -s mvn:org.apache.derby/derby/10.10.1.1

Install into Fuse with:

> features:addurl mvn:org.redhat.examples/transformation-and-cbr/1.0.0-SNAPSHOT/xml/features

> features:install transformation-and-cbr

And you can see the application running by tailing the logs

  log:tail

And you can use ctrl + c to stop tailing the log.

## Testing via the Fuse Management Console

From the Fuse console, select the ActiveMQ tab, and inject sample XML messages (found in src/data) into the payload window:

![amq-console](src/img/amqTestMessage.png)

Getting Help
============================

If you hit any problems please let the Fuse team know on the forums
  [https://community.jboss.org/en/jbossfuse]
