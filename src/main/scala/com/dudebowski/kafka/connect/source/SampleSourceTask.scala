package com.dudebowski.kafka.connect.source

import java.util

import com.typesafe.scalalogging.slf4j.StrictLogging
import org.apache.kafka.connect.errors.ConnectException
import org.apache.kafka.connect.source.{SourceRecord, SourceTask}

import scala.collection.JavaConverters._

/**
 * Created by amutter on 24-12-16.
 */
class SampleSourceTask extends SourceTask with StrictLogging {
  var poller: Option[SampleSourcePoller] = None

  override def stop(): Unit = {
    logger.info("Stop")
  }


  override def start(map: util.Map[String, String]): Unit = {
      logger.info("start")
  }

  override def version(): String = "1.0.0"

  override def poll(): util.List[SourceRecord] = poller match{
    case Some(poller) =>poller.poll.asJava
    case None => throw new ConnectException("SampleSource task is not initialized but it is polled")
  }
}
