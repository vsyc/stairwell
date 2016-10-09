package com.example.stairwell

object StairwellMin {

  def main(args: Array[String]) {

    val stairsFlights = args.slice(0, args.length - 1).toList
    val stepsPerStride = args(args.length - 1).toInt
    val landings = stairsFlights.size - 1
    val stepsPerLanding = 2

    println("You have " + stairsFlights.size + " stairs flight(s) with " + landings + " landing(s), steps per stride " + stepsPerStride)

    val stridesToTop = stairsFlights.map(steps => {
      math.ceil(steps.toFloat / stepsPerStride)
    }).sum.toInt + (landings * stepsPerLanding)

    println("Number of strides to get to the top: " + stridesToTop )
  }

}
