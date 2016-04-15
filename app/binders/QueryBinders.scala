package binders

import play.api.i18n.Lang
import play.api.mvc.QueryStringBindable

object QueryBinders {

  implicit object LangQueryStringBindable extends QueryStringBindable[Lang] {

    override def bind(key: String, params: Map[String, Seq[String]]): Option[Either[String, Lang]] = {
      val code = params.get(key).flatMap(_.headOption)
      code.map(c => Lang.get(c).toRight(s"Language $c is not recognized"))
    }

    override def unbind(key: String, value: Lang): String = {
      value.code
    }

  }

}