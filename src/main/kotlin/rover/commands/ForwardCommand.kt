package mars.commnads

import mars.rover.Rover
import mars.rover.core.RoverGear
import mars.rover.core.Command

class ForwardCommand:Command{
    override fun execute(rover: Rover) {
        rover.move(RoverGear.FORWARD)
    }
}