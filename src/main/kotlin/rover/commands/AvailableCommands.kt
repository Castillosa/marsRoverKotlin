package mars.rover.commands

import mars.rover.core.Command
import mars.commnads.*


enum class AvailableCommands(var command: Command){
    L(TurnLeftCommand()),
    R(TurnRightCommand()),
    F(ForwardCommand()),
    B(BackwardCommand());

    companion object {
        fun getCommand(commandString: String): Command =
            requireNotNull(AvailableCommands.valueOf(commandString).command)
                          { "No command implemented for $commandString" }
    }

}


