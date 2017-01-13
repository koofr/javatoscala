package models

import scala.util.Try
import java.io.ByteArrayInputStream
import com.mysema.scalagen.Converter
import com.github.javaparser.JavaParser

object Conversion {

  val DEFAULT_ENCODING = "UTF-8"

  def convert(original: String): Try[String] = Try {
    val bytes = original.getBytes(DEFAULT_ENCODING)
    val inputStream = new ByteArrayInputStream(bytes)

    val compilationUnit = JavaParser.parse(inputStream, DEFAULT_ENCODING)

    Converter.instance210.toScala(compilationUnit)
  }

}
