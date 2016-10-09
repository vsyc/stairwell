package com.example.stairwell.validators

object StairsFlightsValidator extends Validator {

  val maxFlightStairs: Int = 30
  val minFlightStairs: Int = 1

  val maxStepsPerFlight: Int = 20
  val minStepsPerFlight: Int = 1

  def apply(stairsFlights: List[String]): List[String] = {

    if(stairsFlights.isEmpty) {
      throw new IllegalArgumentException("Stairs Flights argument is undefined or empty")
    }

    if(!this.betweenValidation(stairsFlights.size, minFlightStairs, maxFlightStairs)) {
      this.errors += "Stairs flights volume has to be between " + minFlightStairs + " and " + maxFlightStairs
    }

    stairsFlights.indices.foreach(
      index => {
        if (this.isDigit(stairsFlights(index))) {

          if(!this.betweenValidation(stairsFlights(index).toInt, minStepsPerFlight, maxStepsPerFlight)) {
            this.errors += index + " -> " + stairsFlights(index).toInt + ", steps has to be between " + minStepsPerFlight + " and " + maxStepsPerFlight
          }

        } else {
          this.errors += index + " -> " + stairsFlights(index) + " is not Numeric"
        }
      }
    )

    if(StairsFlightsValidator.errors.nonEmpty) {
      throw new IllegalArgumentException("Stairs flights has validation errors:\n" + StairsFlightsValidator.errors.mkString("\n"))
    }

    stairsFlights
  }

}
