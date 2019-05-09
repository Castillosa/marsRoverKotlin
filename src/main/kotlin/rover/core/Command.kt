package mars.rover.core

import mars.rover.Rover


interface Command{

    fun execute(rover:Rover)
}