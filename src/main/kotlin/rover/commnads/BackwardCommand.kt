package mars.commnads

import mars.rover.Rover
import mars.rover.core.RoverGear
import mars.rover.core.Command

class BackwardCommand:Command{
    override fun execute(rover: Rover) {
        rover.move(RoverGear.BACKWARD)
    }
}