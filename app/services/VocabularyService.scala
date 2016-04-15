package services

import models.Vocabulary

import javax.inject.Singleton

import scala.util.Random

import play.api.i18n.Lang

@Singleton
class VocabularyService {

  private var allVocabulary = List(
    Vocabulary(Lang("en"), Lang("es"), "hello", "hola"),
    Vocabulary(Lang("en"), Lang("es"), "play", "jugar")
  )

  def addVocabulary(v: Vocabulary): Boolean = {
    if (!allVocabulary.contains(v)) {
      allVocabulary = v :: allVocabulary
      true
    } else {
      false
    }
  }

  def findRandomVocabulary(sourceLanguage: Lang, targetLanguage: Lang): Option[Vocabulary] = {
    Random.shuffle(allVocabulary.filter { v =>
      v.sourceLanguage == sourceLanguage &&
        v.targetLanguage == targetLanguage
    }).headOption
  }

  def verify(sourceLanguage: Lang, word: String, targetLanguage: Lang, translation: String): Boolean = {
    allVocabulary.contains(Vocabulary(sourceLanguage, targetLanguage, word, translation))
  }

}