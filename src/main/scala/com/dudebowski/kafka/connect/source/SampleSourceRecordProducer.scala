package com.dudebowski.kafka.connect.source

import org.apache.kafka.connect.source.SourceRecord
import org.apache.kafka.connect.data.{Schema, SchemaBuilder}

import java.util
import java.util.Calendar
import scala.collection.JavaConverters._

case class SampleSourceRecordProducer() {

  var partition = Calendar.getInstance().get(Calendar.HOUR)

  def produce(topic: String) : Seq[SourceRecord] = {
    List(
      new SourceRecord(
          ConnectPartition(),
          ConnectOffset(),
          topic,
          Schema.INT32_SCHEMA,
          RecordPayload
        )
    )
  }

  def ConnectPartition(): util.Map[String, Int] = {
    Map("partition" -> partition).asJava
  }

  def ConnectOffset(): util.Map[String, Long] = {
    Map("timestamp" -> System.currentTimeMillis
    ).asJava
  }

  def RecordPayload: Int = {
    Calendar.getInstance().get(Calendar.SECOND)
  }
}
