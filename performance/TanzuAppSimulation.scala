package com.tanzu.perf

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TanzuAppSimulation extends Simulation {

  val httpProtocol = http
    //.baseUrl("http://localhost:8080")
    .baseUrl("http://tanzu-app-deploy-dev.tanzu.fmartin.tech/")

  // A scenario is a chain of requests and pauses
  val scn = scenario("Main scenario")
    .exec(
      http("vote")
        .get("/")
        .check(status.is(200))
    )
    .exec(
      http("list-all")
        .get("/api/helloes")
        .check(status.is(200))
    )
    .exec(
      http("prime")
        .get("/prime/90015329") //900139151
        .check(status.is(200))
    )

  // https://gatling.io/docs/current/general/simulation_setup/  
  setUp(scn.inject(rampUsers(500).during(30.seconds)).protocols(httpProtocol))

}
