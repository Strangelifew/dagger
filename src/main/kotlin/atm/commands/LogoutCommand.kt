package atm.commands

import atm.commands.Command.Result
import javax.inject.Inject

class LogoutCommand @Inject constructor() : Command {
    override fun handleInput(input: List<String>): Result =
        if (input.isEmpty()) Result.inputCompleted() else Result.invalid()
}