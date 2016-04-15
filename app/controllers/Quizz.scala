package controllers

import javax.inject.Inject

import services.VocabularyService

import play.api.mvc._
import play.api.i18n.Lang

class Quizz @Inject() (vocabulary: VocabularyService) extends Controller {

  def quizz(sourceLanguage: Lang, targetLanguage: Lang) = Action { request =>
    vocabulary.findRandomVocabulary(sourceLanguage, targetLanguage) match {
      case Some(_) => Ok
      case None => NotFound
    }
  }

  def check(sourceLanguage: Lang, word: String, targetLanguage: Lang, translation: String) = Action { request =>
    vocabulary.verify(sourceLanguage, word, targetLanguage, translation) match {
      case true => Ok
      case false => NotAcceptable
    }
  }

}