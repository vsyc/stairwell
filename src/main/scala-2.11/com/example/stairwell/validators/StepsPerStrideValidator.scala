package com.example.stairwell.validators

object StepsPerStrideValidator extends Validator {

  val minStepsPerStride: Int = 1
  val maxStepsPerStride: Int = 4

  def apply(stepsPerStride: String): Int = {

    if(stepsPerStride.isEmpty) {
      throw new IllegalArgumentException("Steps per stride argument is undefined or empty")
    }

    if(this.isDigit(stepsPerStride)) {
      if (!this.betweenValidation(stepsPerStride.toInt, minStepsPerStride, maxStepsPerStride)) {
        this.errors += "Steps per stride is " + stepsPerStride + ", steps has to be between " + minStepsPerStride + " and " + maxStepsPerStride
      }
    } else {
      this.errors += stepsPerStride + " is not Numeric"
    }

    if(StepsPerStrideValidator.errors.nonEmpty) {
      throw new IllegalArgumentException("Steps per stride have validation errors:\n" + StepsPerStrideValidator.errors.mkString("\n"))
    }

    stepsPerStride.toInt
  }

}
