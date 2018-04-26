package controllers

import javax.inject._

import play.api.libs.mailer.{Email, MailerClient}
import play.api.mvc._
import services.MailerService

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(
                                cc: ControllerComponents,
                                mailService: MailerService
                              ) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok("Hello World!")
  }

  def mail = Action {
    mailService.sendEmail
    Ok("mail send")
  }


}
