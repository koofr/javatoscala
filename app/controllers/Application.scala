package controllers

import javax.inject._
import scala.util._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Conversion

@Singleton
class Application @Inject() extends Controller {

  val exampleCode = """
    |package hello;
    |
    |class HelloWorldApp {
    |    public static void main(String[] args) {
    |        System.out.println("Hello World!");
    |    }
    |}
    |""".stripMargin

  val convertForm = Form(
    "original" -> nonEmptyText
  )

  def index = Action {
    Ok(views.html.index(convertForm.fill(exampleCode)))
  }

  def convert = Action { implicit request =>
    convertForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(errors)),
      original => {
        Conversion.convert(original) match {
          case Success(converted) =>
            Ok(views.html.convert(converted))
          case Failure(e) =>
            val form = convertForm.fill(original).withGlobalError(e.toString)

            Ok(views.html.index(form))
        }
      }
    )
  }

}
