/*
 * Copyright (C) 2017 Lightbend Inc. <http://www.lightbend.com>
 */
package doc.akka.management.cluster.bootstrap

import akka.actor.ActorSystem
import akka.annotation.InternalApi
import akka.discovery.SimpleServiceDiscovery.Resolved
import akka.event.Logging
import akka.management.cluster.bootstrap.ClusterBootstrap

import scala.concurrent.Future
import scala.concurrent.duration.FiniteDuration

object ClusterBootstrapCompileOnly {

  val system = ActorSystem()
  ClusterBootstrap(system).start()

}

