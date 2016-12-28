# KafkaConnector
================

[![Build Status](https://travis-ci.org/dudebowski/KafkaConnector.svg?branch=master)](https://travis-ci.org/dudebowski/KafkaConnect)
Sample Kafka connector written in Scala

A sample project to get started with [Kafka Connect](http://docs.confluent.io/3.0.1/connect/intro.html#quickstart) in Scala
The sample is a trivial dodgy counter of seconds.

The project is created with 

* Scala 2.11.7
* Gradle3.0  
* Intellij 2016.1.4
* Confluent 3.0.1

As a prerequisite some Scala experience and the Confluent quick start are recomended quick start

Setup
-----
In addition to the general config in connect-avro-standalone.properties
use the following extra properties

connect-avro-standalone.properties
```yaml
#connect-sample-source.properties
name=connect-sample-source
topic=sampletopic
duration=10000
connector.class=com.dudebowski.kafka.connect.source.SampleSourceConnector
```

Where duration is the interval in millis between messages.

The topic has to be created with the following schema
```json
{"type": "int"}
```
or auto create must be enabled in the server properties.

Usage
-----

Build.

    gradle build shadowJar

Put jar into `CLASSPATH`.

    export CLASSPATH=`realpath ./build/libs/KafkaConnector-1.0.1-all.jar`

With `$CONFLUENT_HOME` pointing to the root of your Confluent Platform installation, start.

    $CONFLUENT_HOME/bin/connect-standalone $CONFLUENT_HOME/etc/schema-registry/connect-avro-standalone.properties connect-sample-source.properties
