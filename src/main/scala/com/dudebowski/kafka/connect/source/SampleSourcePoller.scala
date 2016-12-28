package com.dudebowski.kafka.connect.source

import com.typesafe.scalalogging.slf4j.StrictLogging
import org.apache.kafka.connect.source.SourceRecord

class SampleSourcePoller(cfg: SampleSourceConfig) extends StrictLogging {
  val topic = cfg.getString("topic")
  val duration= cfg.getLong("duration")

  def poll(): Seq[SourceRecord] = {
    Thread.sleep(duration)
    logger.info("poll")
    SampleSourceRecordProducer().produce(topic)
   }
}




