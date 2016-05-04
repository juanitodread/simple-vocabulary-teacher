package services

import javax.inject.Singleton

import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

@Singleton
class TestService {

  val Second = 1000

  def doTaskBlocking(seconds: Int): Unit = {
    Thread.sleep(Second * seconds)
  }

  def doTaskInBackground(seconds: Int): Unit = {
    Future {
      println(s"Starting task: ${Thread.currentThread.getName} in background...")
      Thread.sleep(Second * seconds)
    } onSuccess {
      case u => println(s"Task: ${Thread.currentThread.getName} finished")
    }
  }

}
