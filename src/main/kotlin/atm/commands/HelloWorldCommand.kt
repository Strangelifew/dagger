package atm.commands

import atm.io.Outputter
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(private val outputter: Outputter) : Command {

    override fun handleInput(input: List<String>): Command.Result {
        if (input.isNotEmpty()) {
            return Command.Result.invalid()
        }
        outputter.output("world!")
        return Command.Result.handled()
    }
}