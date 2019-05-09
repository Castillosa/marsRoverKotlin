package mars.commnads

import mars.rover.Rover
import mars.rover.core.Command

class TurnLeftCommand:Command{
    override fun execute(rover: Rover) {
        rover.rotate(-90)
    }
}