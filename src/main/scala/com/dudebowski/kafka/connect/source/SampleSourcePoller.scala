package com.dudebowski.kafka.connect.source

import com.typesafe.scalalogging.slf4j.StrictLogging
import org.apache.kafka.connect.source.SourceRecord

class SampleSourcePoller(cfg: SampleSourceConfig) extends StrictLogging {
  val topic = cfg.getString("topic")

  def poll(): Seq[SourceRecord] = {
    logger.info("poll")

    SampleSourceRecordProducer().produce("")
  }
}



