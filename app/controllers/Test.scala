package controllers

import javax.inject.Inject

import services.TestService

import play.api.mvc._

class Test @Inject() (test: TestService) extends Controller {

  def doTaskBlocking(seconds: Int) = Action { request =>
    test.doTaskBlocking(seconds)
    Ok("Done")
  }

  def doTaskInBackground(seconds: Int) = Action { request =>
    test.doTaskInBackground(seconds)
    Ok("Done in background")
  }

}
