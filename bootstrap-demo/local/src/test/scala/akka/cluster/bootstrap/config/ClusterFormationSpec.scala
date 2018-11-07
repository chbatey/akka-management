package akka.cluster.bootstrap.config

import com.typesafe.config.ConfigFactory
import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, WordSpec}

object ClusterFormationSpec {
  SocketUtil
  val config = ConfigFactory.parseString(s"""
      akka.remote.artery.canonical.hostname = "127.0.0.$nr"
      akka.management.http.hostname = "127.0.0.$nr"
    """).withFallback(ConfigFactory.load())
  val system = ActorSystem("local-cluster", config)

  AkkaManagement(system).start()
  ClusterBootstrap(system).start()

  Cluster(system).registerOnMemberUp({
    system.log.info("Cluster is up!")
  })

}

class ClusterFormationSpec extends WordSpec with BeforeAndAfterAll {

  "Cluster formation via config" should {
    "work" in {

    }
  }

}
