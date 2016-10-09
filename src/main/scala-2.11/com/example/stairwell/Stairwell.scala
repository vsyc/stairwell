package com.example.stairwell

import com.example.stairwell.validators.{StairsFlightsValidator, StepsPerStrideValidator}

object Stairwell {

  val stepsPerLanding: Int = 2

  def main(args: Array[String]) {

    if(args.length < 2) {
      throw new IllegalArgumentException("Has to be 2 or more arguments")
    }

    val extractArgumentAt = (args: Array[String], index: Int) => {
      if(args.isDefinedAt(index))
        args(index).trim
      else
        ""
    }

    this.calculateStridesToTop(
      StairsFlightsValidator(args.slice(0, args.length - 1).toList),
      StepsPerStrideValidator(extractArgumentAt(args, args.length - 1))
    )

  }

  /**
    *
    * @param stairsFlights List[String]
    * @param stepsPerStride Int
    */
  def calculateStridesToTop(stairsFlights: List[String], stepsPerStride: Int): Unit = {

    val landings = stairsFlights.size - 1

    println("You have " + stairsFlights.size + " stairs flight(s) with " + landings + " landing(s), steps per stride " + stepsPerStride)

    val stridesToTop: Int = stairsFlights.map(steps => {
      math.ceil(steps.toFloat / stepsPerStride)
    }).sum.toInt + (landings * stepsPerLanding)

    println("Number of strides to get to the top: " + stridesToTop)
  }

}
