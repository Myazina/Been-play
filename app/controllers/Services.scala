package controllers

import play.api._
import mvc.{Action, Controller}

/**
 * Created with IntelliJ IDEA.
 * User: dmitriyr
 * Date: 7/17/12
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */

case class ServiceInfo(
  id: String,
  description: String
)


object Services extends Controller {

  var listOfServices = List(ServiceInfo("softwarerepository", "Software Repository"))
  var status = "OFF"
  //listOfServices += ServiceInfo("softwarerepository", "Software Repository")
  //listOfServices += ServiceInfo("hostmanager" -> "Host Manager")
  //listOfServices += ServiceInfo("benchmarkmanager" -> "Benchmark Manager")
  //listOfServices += ServiceInfo("resultsrepository" -> "Results Repository")

  def index = Action {
    Ok(views.html.services(status, listOfServices))
  }

  def toggle = Action {
    if (status == "OFF") status = "ON" else status = "OFF"
    Ok(views.html.services(status, listOfServices))
  }
}