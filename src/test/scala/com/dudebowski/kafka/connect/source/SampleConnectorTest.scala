package com.dudebowski.kafka.connect.source

import java.util.Calendar

import com.typesafe.scalalogging.slf4j.StrictLogging
import org.apache.kafka.connect.data.{Schema, SchemaBuilder}
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

import scala.collection.JavaConverters._


class SampleConnectorTest extends FunSuite with Matchers with BeforeAndAfter with StrictLogging  {
  test("testing the sample connector") {
    SampleSourceConfig.Topic shouldBe "topic"
    val producer = new SampleSourceRecordProducer()
    val hour = Calendar.getInstance().get(Calendar.HOUR)
    producer.ConnectPartition().asScala.exists(_ ==("partition", hour)) shouldBe true
  }
}
