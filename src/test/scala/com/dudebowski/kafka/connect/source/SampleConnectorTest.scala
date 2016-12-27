package com.dudebowski.kafka.connect.source

import java.util.Calendar

import com.typesafe.scalalogging.slf4j.StrictLogging
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}
import sun.util.resources.cldr.th.CalendarData_th_TH

import scala.collection.JavaConverters._


class SampleConnectorTest extends FunSuite with Matchers with BeforeAndAfter with StrictLogging  {
  test("testing the sample connector") {
    SampleSourceConfig.Topic shouldBe "sampleTopic"
    var producer = new SampleSourceRecordProducer()
    val hour = Calendar.getInstance().get(Calendar.HOUR)
    producer.ConnectPartition().asScala.exists(_ ==("partition", hour)) shouldBe true
  }
}
