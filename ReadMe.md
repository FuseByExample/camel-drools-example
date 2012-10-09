Drools-Camel Component Example
==============================

**NOTE** that this example has been included in the [Fuse project itself](https://github.com/fusesource/fuse/tree/master/tooling/examples/camel-drools-example) and is now used to create the Drools Camel archetype. If you want to see the most up to date version of this example see [here](https://github.com/fusesource/fuse/tree/master/tooling/examples/camel-drools-example)


To build this project use

    mvn install

This project includes a unit test, com.redhat.example.drools.CamelContextXmlTest, that shows calling this component

To run this project use

    mvn camel:run

To deploy this project into [Fuse ESB](http://fusesource.com/downloads)

Start Fuse ESB

    <Fuse ESB Home>/bin/fuseesb

In the Fuse ESB console, use the following

    FuseESB:karaf@root> features:addurl mvn:com.redhat.example/camel-drools-example/1.0.0-SNAPSHOT/xml/features
    FuseESB:karaf@root> features:install camel-drools-examples

To see the results tail the Fuse ESB log

    tail -f <Fuse ESB Home>/data/log/fuseesb.log
