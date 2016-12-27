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
          ConnectPartition(),                // source partion
          ConnectOffset(),                   // source offset
          topic,                             //topic
          Schema.STRING_SCHEMA,              // key schema
          java.util.UUID.randomUUID(),       // key
          Schema.BYTES_SCHEMA,               // Schema
          RecordPayload                      // val)
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

  def RecordPayload: util.Map[String, Int] = {
    Map("seconds" -> Calendar.getInstance().get(Calendar.SECOND),
        "Minutes" -> Calendar.getInstance().get(Calendar.SECOND)
    ).asJava
  }

  val schema = SchemaBuilder.struct().name("com.dudebowski.kafka.connect")
    .field("name", Schema.STRING_SCHEMA)
    .field("offset", Schema.INT64_SCHEMA)
    .build()
}
