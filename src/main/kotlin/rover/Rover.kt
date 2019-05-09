package mars.rover
import mars.tools.CardinalPoints
import mars.rover.commands.AvailableCommands
import mars.rover.core.RoverGear
import mars.tools.sphereSimulation

class Rover(var x:Int,var y:Int,var orientation:String = "N",var xLimit:Int =100, var yLimit:Int = 100){
    var speed:Int  = 1

    fun rotate(degreesRotation:Int){
        var orientationDegrees = CardinalPoints.getDegrees(this.orientation)
        var degreeCandidate = orientationDegrees + degreesRotation
            when {
                //Simulate sphere rotation
                degreeCandidate > 359 -> degreeCandidate -= 360
                degreeCandidate < 0 -> degreeCandidate += 360
            }
        this.orientation = CardinalPoints.getOrientation(degreeCandidate)
    }

    fun move(gear: RoverGear){
        var movementVector = this.speed * gear.speedMultiplicator

        //South and WEST Forward == NORTH, EAST Backwards
        if (this.orientation == "S" || this.orientation=="W"){
            movementVector *= -1 //Forward in Shouth and West is negative
        }

        when(this.orientation){
            //avoiding negative points, MarsRover1 is in a planet
            "N","S" -> this.y = sphereSimulation(this.y,movementVector,this.yLimit)
            "E","W" -> this.x = sphereSimulation(this.x,movementVector,this.xLimit)
        }
    }

    fun execute(commandsArray: Array<String>){
        for (comString in commandsArray){
            var com = AvailableCommands.getCommand(comString)
            com.execute(this)
        }
    }

}



