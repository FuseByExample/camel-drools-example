Drools-Camel Component Example
==============================

NOTE: This project is not supported on JBoss Fuse version 6.3 or later
----------------------------------------------------------------------
See the Fuse Integration Pack at http://developers.redhat.com/products/fuse/download/

To build this project use

    mvn install

This project includes a unit test, com.redhat.example.drools.CamelContextXmlTest, that shows calling this component

To run this project use

    mvn camel:run

To deploy this project into [Fuse ESB](http://fusesource.com/downloads)

Start Fuse ESB

    <Fuse ESB Home>/bin/fuseesb

In the Fuse ESB console, use the following

    FuseESB:karaf@root> features:addurl mvn:com.redhat.example/camel-drools-example/1.2.0-SNAPSHOT/xml/features
    FuseESB:karaf@root> features:install camel-drools-example

To see the results tail the Fuse ESB log

    tail -f <Fuse ESB Home>/data/log/fuseesb.log

## Note for vanilla Karaf users

You may need to edit `etc/org.ops4j.pax.url.mvn.cfg`, and add to the `org.ops4j.pax.url.mvn.repositories` property an
entry for the FuseSource repository `http://repo.fusesource.com/nexus/content/repositories/releases/`
