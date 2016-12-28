package com.dudebowski.kafka.connect.source

import java.util

import org.apache.kafka.common.config.{AbstractConfig, ConfigDef}
import org.apache.kafka.common.config.ConfigDef.{Type, Importance}

// abstraction for configs
class SampleSourceConfig(props: util.Map[String, String])
  extends AbstractConfig(SampleSourceConfig.definition, props) {

}
object SampleSourceConfig {

  val Topic = "topic"
  val Duration = "duration"

  val definition: ConfigDef = new ConfigDef()
    .define(Topic,Type.STRING,Importance.HIGH,"Target topic")
    .define(Duration,Type.INT,Importance.HIGH,"polling sleep duration")
}

