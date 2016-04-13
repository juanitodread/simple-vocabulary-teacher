package services

import models.Vocabulary

import javax.inject.Singleton
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

}