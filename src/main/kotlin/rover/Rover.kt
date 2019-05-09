package mars.rover
import mars.tools.CardinalPoints
import mars.rover.core.Command
import mars.rover.core.RoverGear

class Rover(var x:Int,var y:Int,var orientation:String = "N"){
    var speed:Int  = 1

    fun rotate(degreesRotation:Int){
        var orientationDegrees = CardinalPoints.getDegrees(this.orientation)
        var degreeCandidate = orientationDegrees + degreesRotation
            when {
                degreeCandidate > 359 -> degreeCandidate -= 360
                degreeCandidate < 0 -> degreeCandidate += 360
            }
        this.orientation = CardinalPoints.getOrientation(degreeCandidate)
    }

    fun move(gear: RoverGear){
        var candidatePoint = this.speed * gear.speedMultiplicator
        
        if (this.orientation == "S" || this.orientation=="W"){
            candidatePoint *= -1
        }

        when(this.orientation){
            "N","S" -> this.y += candidatePoint
            "E","W" -> this.x += candidatePoint
        }
        /**/
    }

    fun execute(commandsArray: Array<Command>){
        for (com in commandsArray){
            com.execute(this)
        }
    }

}



