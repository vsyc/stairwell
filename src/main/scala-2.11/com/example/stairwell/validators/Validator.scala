package com.example.stairwell.validators

import scala.collection.mutable.ListBuffer

trait Validator {

  val errors: ListBuffer[String] = ListBuffer[String]()

  def isDigit(value: String) : Boolean = {
    (value != "") && value.forall(Character.isDigit)
  }

  def betweenValidation(value: Int, min: Int, max: Int): Boolean = {
    value >= min && value <= max
  }

}
